package com.dongjin.hospitalapp.repository

import android.util.Log
import com.dongjin.hospitalapp.data.GeocodingService
import com.dongjin.hospitalapp.data.Hospital
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Singleton
class HospitalRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    val geocodingService: GeocodingService // public으로 변경
) {
    suspend fun getHospitals(): List<Hospital> {
        return try {
            val snapshot = firestore.collection("hospitals").get().await()
            snapshot.documents.mapNotNull { it.toObject(Hospital::class.java) }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    /**
     * 우선순위가 높은 병원들의 좌표를 지오코딩으로 업데이트 (서울/경기 지역 위주)
     */
    suspend fun updateHospitalCoordinates(): List<Hospital> {
        Log.d("HospitalRepository", "🗺️ 병원 좌표 업데이트 시작")
        
        val hospitals = getHospitals()
        
        // 좌표가 없는 병원들 중 서울/경기/인천 지역만 우선 처리 (API 호출 최소화)
        val hospitalsNeedingCoordinates = hospitals.filter { 
            (it.latitude == null || it.longitude == null) &&
            (it.sido?.contains("서울", ignoreCase = true) == true ||
             it.sido?.contains("경기", ignoreCase = true) == true ||
             it.sido?.contains("인천", ignoreCase = true) == true)
        }.take(100) // 최대 100개만 처리해서 속도 향상
        
        if (hospitalsNeedingCoordinates.isEmpty()) {
            Log.d("HospitalRepository", "✅ 우선순위 병원들의 좌표가 이미 설정됨")
            return hospitals
        }
        
        Log.d("HospitalRepository", "🔍 우선순위 ${hospitalsNeedingCoordinates.size}개 병원 좌표 변환 중...")
        
        // 지오코딩으로 좌표 업데이트
        val updatedHospitals = geocodingService.updateHospitalsWithCoordinates(hospitalsNeedingCoordinates)
        
        // Firestore에 업데이트된 좌표 저장
        updatedHospitals.forEach { hospital ->
            if (hospital.latitude != null && hospital.longitude != null) {
                try {
                    val hospitalData = mapOf(
                        "name" to hospital.name,
                        "type" to hospital.type,
                        "address" to hospital.address,
                        "tel" to hospital.tel,
                        "url" to hospital.url,
                        "subject" to hospital.subject,
                        "sido" to hospital.sido,
                        "sggu" to hospital.sggu,
                        "latitude" to hospital.latitude,
                        "longitude" to hospital.longitude
                    )
                    
                    // 병원 이름을 document ID로 사용
                    val docId = hospital.name?.replace(" ", "_") ?: "unknown_${System.currentTimeMillis()}"
                    firestore.collection("hospitals").document(docId).set(hospitalData).await()
                    
                } catch (e: Exception) {
                    Log.e("HospitalRepository", "❌ 병원 좌표 저장 실패: ${hospital.name} - ${e.message}")
                }
            }
        }
        
        return getHospitals() // 업데이트된 전체 목록 반환
    }
    
    /**
     * 사용자 위치 기준 근처 병원 찾기 (가까운 병원 우선)
     */
    suspend fun getNearbyHospitals(userLatitude: Double, userLongitude: Double, radiusKm: Double = 20.0): List<Hospital> {
        Log.d("HospitalRepository", "🏥 근처 병원 검색 시작: ($userLatitude, $userLongitude) 반경 ${radiusKm}km")
        
        val allHospitals = getHospitals()
        Log.d("HospitalRepository", "📊 전체 병원 수: ${allHospitals.size}")
        
        val nearbyHospitals = mutableListOf<Hospital>()
        
        // 1. 먼저 좌표가 있는 모든 병원을 거리순으로 정렬하여 처리
        val hospitalsWithCoords = allHospitals.filter { it.latitude != null && it.longitude != null }
        val hospitalsWithDistance = hospitalsWithCoords.map { hospital ->
            val distance = calculateDistance(
                userLatitude, userLongitude,
                hospital.latitude!!, hospital.longitude!!
            )
            Pair(hospital, distance)
        }.sortedBy { it.second } // 거리순 정렬
        
        Log.d("HospitalRepository", "📍 좌표 있는 병원: ${hospitalsWithCoords.size}개")
        
        // 반경 내 병원만 추가
        hospitalsWithDistance.forEach { (hospital, distance) ->
            if (distance <= radiusKm) {
                nearbyHospitals.add(hospital)
                Log.d("HospitalRepository", "✅ 근처 병원 (기존 좌표): ${hospital.name} - ${String.format("%.1f", distance)}km")
            }
        }
        
        // 2. 좌표가 없는 병원들을 지역별로 우선순위를 두어 처리
        val hospitalsWithoutCoords = allHospitals.filter { it.latitude == null || it.longitude == null }
        Log.d("HospitalRepository", "❓ 좌표 없는 병원: ${hospitalsWithoutCoords.size}개")
        
        if (hospitalsWithoutCoords.isNotEmpty() && nearbyHospitals.size < 30) {
            Log.d("HospitalRepository", "🔍 좌표 없는 병원들을 지오코딩으로 처리 중...")
            
            // 사용자 지역 확인
            val userRegion = getUserRegionFromCoordinates(userLatitude, userLongitude)
            Log.d("HospitalRepository", "🌍 사용자 지역: $userRegion")
            
            // 지역별 우선순위로 정렬 (같은 시/도 → 인접 지역 → 기타)
            val prioritizedHospitals = hospitalsWithoutCoords
                .filter { !it.address.isNullOrBlank() }
                .sortedWith(compareBy<Hospital> { hospital ->
                    val hospitalRegion = hospital.sido ?: ""
                    when {
                        // 1순위: 같은 시/도
                        hospitalRegion.contains(userRegion) -> 1
                        // 2순위: 인접 지역
                        isAdjacentRegion(userRegion, hospitalRegion) -> 2
                        // 3순위: 기타 지역
                        else -> 3
                    }
                }.thenBy { hospital ->
                    // 같은 우선순위 내에서는 구/군별로 정렬 (더 구체적인 주소 우선)
                    hospital.sggu?.length ?: 0
                })
                .take(25) // 최대 25개로 증가 (빠른 API 호출로 더 많이 처리)
            
            Log.d("HospitalRepository", "🌍 지오코딩 대상 병원: ${prioritizedHospitals.size}개")
            
            // 우선순위 순으로 지오코딩 처리 (조기 종료 조건 추가)
            prioritizedHospitals.forEachIndexed { index, hospital ->
                // 충분한 병원을 찾았으면 조기 종료
                if (nearbyHospitals.size >= 20) {
                    Log.d("HospitalRepository", "🎯 충분한 병원(20개) 발견, 지오코딩 조기 종료")
                    return@forEachIndexed
                }
                
                try {
                    Log.d("HospitalRepository", "🔍 [$index/${prioritizedHospitals.size}] 지오코딩 시도: ${hospital.name} (${hospital.sido} ${hospital.sggu})")
                    val coords = geocodingService.getCoordinatesFromAddress(hospital.address)
                    
                    if (coords != null) {
                        val distance = calculateDistance(
                            userLatitude, userLongitude,
                            coords.first, coords.second
                        )
                        
                        Log.d("HospitalRepository", "📏 거리 계산: ${hospital.name} - ${String.format("%.1f", distance)}km")
                        
                        if (distance <= radiusKm) {
                            val updatedHospital = hospital.copy(
                                latitude = coords.first,
                                longitude = coords.second
                            )
                            nearbyHospitals.add(updatedHospital)
                            
                            Log.d("HospitalRepository", "✅ 근처 병원 (지오코딩): ${hospital.name} - ${String.format("%.1f", distance)}km")
                            
                            // 백그라운드에서 비동기 좌표 저장 (메인 플로우에 영향 없음)
                            CoroutineScope(Dispatchers.IO).launch {
                                saveHospitalCoordinates(hospital, coords.first, coords.second)
                            }
                        } else {
                            Log.d("HospitalRepository", "❌ 반경 밖 병원: ${hospital.name} - ${String.format("%.1f", distance)}km")
                        }
                    } else {
                        Log.w("HospitalRepository", "⚠️ 지오코딩 결과 없음: ${hospital.name}")
                    }
                    
                    // API 호출 간격 (20ms로 더 단축)
                    kotlinx.coroutines.delay(20)
                    
                } catch (e: Exception) {
                    Log.e("HospitalRepository", "❌ 지오코딩 실패: ${hospital.name} - ${e.message}")
                }
            }
        }
        
        // 3. 최종 거리순 정렬하여 반환
        val sortedHospitals = nearbyHospitals.sortedBy { hospital ->
            if (hospital.latitude != null && hospital.longitude != null) {
                calculateDistance(userLatitude, userLongitude, hospital.latitude!!, hospital.longitude!!)
            } else {
                999.0
            }
        }
        
        Log.d("HospitalRepository", "🎯 최종 근처 병원 ${sortedHospitals.size}개 발견")
        
        // 가장 가까운 5개 병원 로그 출력
        sortedHospitals.take(5).forEachIndexed { index, hospital ->
            if (hospital.latitude != null && hospital.longitude != null) {
                val distance = calculateDistance(userLatitude, userLongitude, hospital.latitude!!, hospital.longitude!!)
                Log.d("HospitalRepository", "🏆 TOP ${index + 1}: ${hospital.name} - ${String.format("%.1f", distance)}km")
            }
        }
        
        return sortedHospitals
    }
    
    /**
     * 인접 지역 확인
     */
    private fun isAdjacentRegion(userRegion: String, hospitalRegion: String): Boolean {
        return when (userRegion) {
            "서울" -> hospitalRegion.contains("경기") || hospitalRegion.contains("인천")
            "경기" -> hospitalRegion.contains("서울") || hospitalRegion.contains("인천") || hospitalRegion.contains("강원") || hospitalRegion.contains("충북") || hospitalRegion.contains("충남")
            "인천" -> hospitalRegion.contains("서울") || hospitalRegion.contains("경기")
            "부산" -> hospitalRegion.contains("울산") || hospitalRegion.contains("경남")
            "대구" -> hospitalRegion.contains("경북") || hospitalRegion.contains("경남")
            "광주" -> hospitalRegion.contains("전남") || hospitalRegion.contains("전북")
            "대전" -> hospitalRegion.contains("충남") || hospitalRegion.contains("충북")
            "울산" -> hospitalRegion.contains("부산") || hospitalRegion.contains("경남")
            "강원" -> hospitalRegion.contains("경기") || hospitalRegion.contains("충북")
            "충북" -> hospitalRegion.contains("대전") || hospitalRegion.contains("충남") || hospitalRegion.contains("경기") || hospitalRegion.contains("강원")
            "충남" -> hospitalRegion.contains("대전") || hospitalRegion.contains("충북") || hospitalRegion.contains("경기")
            "전북" -> hospitalRegion.contains("광주") || hospitalRegion.contains("전남") || hospitalRegion.contains("충남")
            "전남" -> hospitalRegion.contains("광주") || hospitalRegion.contains("전북")
            "경북" -> hospitalRegion.contains("대구") || hospitalRegion.contains("경남") || hospitalRegion.contains("강원")
            "경남" -> hospitalRegion.contains("부산") || hospitalRegion.contains("울산") || hospitalRegion.contains("대구") || hospitalRegion.contains("경북")
            "제주" -> false
            else -> false
        }
    }
    
    /**
     * 두 좌표 간의 거리 계산 (Haversine 공식)
     */
    private fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val earthRadius = 6371.0 // km
        val lat1Rad = Math.toRadians(lat1)
        val lat2Rad = Math.toRadians(lat2)
        val deltaLat = Math.toRadians(lat2 - lat1)
        val deltaLon = Math.toRadians(lon2 - lon1)

        val a = sin(deltaLat / 2) * sin(deltaLat / 2) +
                cos(lat1Rad) * cos(lat2Rad) *
                sin(deltaLon / 2) * sin(deltaLon / 2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return earthRadius * c
    }
    
    /**
     * 좌표로부터 대략적인 지역 추정 (확장된 지역 범위)
     */
    private fun getUserRegionFromCoordinates(lat: Double, lng: Double): String {
        return when {
            // 서울특별시
            lat in 37.40..37.70 && lng in 126.80..127.20 -> "서울"
            
            // 경기도 (서울 주변)
            lat in 37.10..38.00 && lng in 126.60..127.80 -> "경기"
            
            // 인천광역시  
            lat in 37.30..37.60 && lng in 126.50..126.90 -> "인천"
            
            // 부산광역시
            lat in 35.00..35.40 && lng in 128.90..129.30 -> "부산"
            
            // 대구광역시
            lat in 35.70..36.00 && lng in 128.40..128.80 -> "대구"
            
            // 광주광역시
            lat in 35.00..35.30 && lng in 126.70..127.00 -> "광주"
            
            // 대전광역시
            lat in 36.20..36.50 && lng in 127.20..127.60 -> "대전"
            
            // 울산광역시
            lat in 35.40..35.70 && lng in 129.10..129.50 -> "울산"
            
            // 강원도
            lat in 37.00..38.70 && lng in 127.00..129.50 -> "강원"
            
            // 충청북도  
            lat in 36.00..37.20 && lng in 127.20..128.80 -> "충북"
            
            // 충청남도
            lat in 35.80..37.00 && lng in 126.00..127.80 -> "충남"
            
            // 전라북도
            lat in 35.50..36.30 && lng in 126.40..127.80 -> "전북"
            
            // 전라남도
            lat in 34.20..35.80 && lng in 125.00..127.50 -> "전남"
            
            // 경상북도
            lat in 35.40..37.50 && lng in 128.00..130.00 -> "경북"
            
            // 경상남도
            lat in 34.50..36.00 && lng in 127.70..129.50 -> "경남"
            
            // 제주특별자치도
            lat in 33.10..33.60 && lng in 126.10..126.90 -> "제주"
            
            else -> "기타"
        }
    }
    
    /**
     * 파이어스토어에 병원 좌표 저장
     */
    private suspend fun saveHospitalCoordinates(hospital: Hospital, latitude: Double, longitude: Double) {
        try {
            val docId = hospital.name?.replace(" ", "_")?.replace("(", "")?.replace(")", "") ?: "unknown_${System.currentTimeMillis()}"
            
            val hospitalData = mapOf(
                "name" to hospital.name,
                "type" to hospital.type,
                "address" to hospital.address,
                "tel" to hospital.tel,
                "url" to hospital.url,
                "subject" to hospital.subject,
                "sido" to hospital.sido,
                "sggu" to hospital.sggu,
                "latitude" to latitude,
                "longitude" to longitude,
                "updatedAt" to com.google.firebase.Timestamp.now()
            )
            
            firestore.collection("hospitals").document(docId).set(hospitalData).await()
            Log.d("HospitalRepository", "💾 좌표 저장 완료: ${hospital.name}")
            
        } catch (e: Exception) {
            Log.e("HospitalRepository", "❌ 좌표 저장 실패: ${hospital.name} - ${e.message}")
        }
    }
}

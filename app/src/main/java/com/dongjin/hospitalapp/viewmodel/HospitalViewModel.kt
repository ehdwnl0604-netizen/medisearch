package com.dongjin.hospitalapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongjin.hospitalapp.data.Hospital
import com.dongjin.hospitalapp.repository.HospitalRepository
import com.dongjin.hospitalapp.util.HospitalCodeMapper
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HospitalViewModel @Inject constructor(
    private val repository: HospitalRepository
) : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()

    private val _hospitalList = MutableStateFlow<List<Hospital>>(emptyList())
    val hospitalList: StateFlow<List<Hospital>> = _hospitalList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _hospitals = MutableStateFlow<List<Hospital>>(emptyList())
    val hospitals: StateFlow<List<Hospital>> = _hospitals

    private var lastQueryKey: String? = null  // ✅ 중복 쿼리 방지 키
    fun fetchHospitals(
        name: String,
        typeCodes: List<String>,
        regionCodes: List<String>
    ) {
        val queryKey = "$name|${typeCodes.joinToString()}|${regionCodes.joinToString()}"
        if (queryKey == lastQueryKey && _hospitalList.value.isNotEmpty()) {
            Log.d("HospitalFetch", "❎ 중복 검색 생략")
            return
        }
        lastQueryKey = queryKey

        viewModelScope.launch {
            Log.d("HospitalFetch", "✅ 검색 시작: name=$name / type=$typeCodes / region=$regionCodes")
            _isLoading.value = true

            var query: Query = firestore.collection("hospitals")

            // 🔸 지역은 Firestore 쿼리로 필터링
            if (regionCodes.isNotEmpty()) {
                query = query.whereIn("sido", regionCodes)
                Log.d("HospitalFetch", "📌 지역 필터: $regionCodes")
            }

            query.get()
                .addOnSuccessListener { snapshot ->
                    Log.d("HospitalFetch", "📦 문서 수신: ${snapshot.size()}개")

                    var result = snapshot.documents.mapNotNull { it.toObject(Hospital::class.java) }

                    result = result.filter { hosp ->
                        // 🔸 종별 OR 필터 (앱 내)
                        val typeMatch = if (typeCodes.isNotEmpty()) {
                            val typeNames = typeCodes.map { HospitalCodeMapper.getTypeNameByCode(it) }
                            typeNames.contains(hosp.type)
                        } else true

                        // 🔸 병원명 검색
                        val nameMatch = if (name.isNotBlank()) {
                            hosp.name?.contains(name, true) == true
                        } else true

                        val match = typeMatch && nameMatch
                        Log.d("HospitalMatch", "🧪 ${hosp.name} - 종별:$typeMatch / 이름:$nameMatch → $match")
                        match
                    }

                    Log.d("HospitalFetch", "✅ 최종 결과: ${result.size}개")
                    _hospitalList.value = result
                    _isLoading.value = false
                }
                .addOnFailureListener { e ->
                    Log.e("HospitalFetch", "❌ 쿼리 실패", e)
                    _isLoading.value = false
                }
        }
    }

    fun resetHospitalList() {
        Log.d("HospitalFetch", "🔄 병원 리스트 초기화 요청")
        _hospitalList.value = emptyList()
        lastQueryKey = null
    }

    fun fetchAllHospitals() {
        viewModelScope.launch {
            Log.d("HospitalFetch", "✅ 전체 병원 데이터 가져오기 시작")
            _isLoading.value = true

            // Firebase 연결 상태 확인
            Log.d("HospitalFetch", "🔗 Firebase 인스턴스: ${firestore}")
            Log.d("HospitalFetch", "🏥 컬렉션 참조: ${firestore.collection("hospitals")}")

            firestore.collection("hospitals")
                .get()
                .addOnSuccessListener { snapshot ->
                    Log.d("HospitalFetch", "📦 전체 문서 수신: ${snapshot.size()}개")
                    
                    // 각 문서의 상세 정보 로그
                    snapshot.documents.forEachIndexed { index, document ->
                        Log.d("HospitalFetch", "📄 문서 [$index]: ${document.id}")
                        Log.d("HospitalFetch", "📄 문서 데이터: ${document.data}")
                    }
                    
                    val result = snapshot.documents.mapNotNull { document ->
                        try {
                            val hospital = document.toObject(Hospital::class.java)
                            if (hospital == null) {
                                Log.w("HospitalFetch", "⚠️ null 변환: ${document.id}")
                            } else {
                                Log.d("HospitalFetch", "✅ 병원 파싱: ${hospital.name} (${hospital.latitude}, ${hospital.longitude})")
                            }
                            hospital
                        } catch (e: Exception) {
                            Log.e("HospitalFetch", "❌ 문서 파싱 실패: ${document.id} - ${e.message}")
                            null
                        }
                    }
                    
                    Log.d("HospitalFetch", "🏥 최종 파싱된 병원 수: ${result.size}")
                    result.forEach { hospital ->
                        Log.d("HospitalFetch", "📍 ${hospital.name}: (${hospital.latitude}, ${hospital.longitude})")
                    }
                    
                    _hospitals.value = result
                    _isLoading.value = false
                }
                .addOnFailureListener { e ->
                    Log.e("HospitalFetch", "❌ 전체 병원 데이터 가져오기 실패", e)
                    Log.e("HospitalFetch", "❌ 에러 타입: ${e.javaClass.simpleName}")
                    Log.e("HospitalFetch", "❌ 에러 메시지: ${e.message}")
                    Log.e("HospitalFetch", "❌ 스택 트레이스: ${e.stackTraceToString()}")
                    _isLoading.value = false
                }
        }
    }
    
    /**
     * 병원 좌표 업데이트 (지오코딩)
     */
    fun updateHospitalCoordinates() {
        viewModelScope.launch {
            _isLoading.value = true
            Log.d("HospitalViewModel", "🗺️ 병원 좌표 업데이트 시작")
            
            try {
                val updatedHospitals = repository.updateHospitalCoordinates()
                _hospitals.value = updatedHospitals
                Log.d("HospitalViewModel", "✅ 병원 좌표 업데이트 완료")
            } catch (e: Exception) {
                Log.e("HospitalViewModel", "❌ 병원 좌표 업데이트 실패: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * 사용자 위치 기준 근처 병원 가져오기
     */
    fun getNearbyHospitals(userLatitude: Double, userLongitude: Double, radiusKm: Double = 10.0) {
        viewModelScope.launch {
            _isLoading.value = true
            
            try {
                val nearbyHospitals = repository.getNearbyHospitals(userLatitude, userLongitude, radiusKm)
                _hospitals.value = nearbyHospitals
                Log.d("HospitalViewModel", "✅ 근처 병원 ${nearbyHospitals.size}개 로드 완료")
            } catch (e: Exception) {
                Log.e("HospitalViewModel", "❌ 근처 병원 검색 실패: ${e.message}")
                _hospitals.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
}

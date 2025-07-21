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

            firestore.collection("hospitals")
                .get()
                .addOnSuccessListener { snapshot ->
                    Log.d("HospitalFetch", "📦 전체 문서 수신: ${snapshot.size()}개")
                    val result = snapshot.documents.mapNotNull { it.toObject(Hospital::class.java) }
                    _hospitals.value = result
                    _isLoading.value = false
                }
                .addOnFailureListener { e ->
                    Log.e("HospitalFetch", "❌ 전체 병원 데이터 가져오기 실패", e)
                    _isLoading.value = false
                }
        }
    }
}

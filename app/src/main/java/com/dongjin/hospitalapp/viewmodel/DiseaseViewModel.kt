package com.dongjin.hospitalapp.viewmodel

import androidx.lifecycle.ViewModel
import com.dongjin.hospitalapp.data.Disease
import com.dongjin.hospitalapp.data.DiseaseData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DiseaseViewModel : ViewModel() {
	private val _diseaseList = MutableStateFlow<List<Disease>>(emptyList())
	val diseaseList: StateFlow<List<Disease>> = _diseaseList

	fun loadDiseases(category: String) {
		_diseaseList.value = DiseaseData.categoryMap[category] ?: emptyList()
	}
}

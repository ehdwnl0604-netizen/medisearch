package com.dongjin.hospitalapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongjin.hospitalapp.data.CaregiverService
import com.dongjin.hospitalapp.repository.CaregiverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaregiverViewModel @Inject constructor(
	private val repository: CaregiverRepository
) : ViewModel() {

	private val _caregiverList = MutableStateFlow<List<CaregiverService>>(emptyList())
	val caregiverList: StateFlow<List<CaregiverService>> = _caregiverList

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading

	fun loadCaregivers(region: String) {
		viewModelScope.launch {
			_isLoading.value = true
			val result = repository.getCaregiverServices(region)
			_caregiverList.value = result
			_isLoading.value = false
		}
	}
}

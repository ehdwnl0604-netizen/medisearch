package com.dongjin.hospitalapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongjin.hospitalapp.data.PolicyFund
import com.dongjin.hospitalapp.repository.PolicyFundRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PolicyFundViewModel @Inject constructor(
	private val repository: PolicyFundRepository
) : ViewModel() {

	private val _funds = MutableStateFlow<List<PolicyFund>>(emptyList())
	val funds: StateFlow<List<PolicyFund>> = _funds

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading

	fun loadFunds() {
		viewModelScope.launch {
			_isLoading.value = true
			_funds.value = repository.getPolicyFunds()
			_isLoading.value = false
		}
	}
}

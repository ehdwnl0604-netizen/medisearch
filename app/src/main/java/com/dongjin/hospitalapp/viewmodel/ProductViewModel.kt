package com.dongjin.hospitalapp.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongjin.hospitalapp.data.Product
import com.dongjin.hospitalapp.repository.ProductRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
	private val repository: ProductRepository
) : ViewModel() {

	private val _products = MutableStateFlow<List<Product>>(emptyList())
	val products: StateFlow<List<Product>> = _products

	private val _isLoading = MutableStateFlow(false)
	val isLoading: StateFlow<Boolean> = _isLoading

	fun loadProducts() {
		viewModelScope.launch {
			_isLoading.value = true
			_products.value = repository.getProducts()
			_isLoading.value = false
		}
	}
}

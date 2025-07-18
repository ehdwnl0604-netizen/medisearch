package com.dongjin.hospitalapp.repository

import com.dongjin.hospitalapp.data.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRepository @Inject constructor(
	private val db: FirebaseFirestore
) {
	suspend fun getProducts(): List<Product> {
		return try {
			val snapshot = db.collection("products").get().await()
			snapshot.documents.mapNotNull { it.toObject(Product::class.java) }
		} catch (e: Exception) {
			emptyList()
		}
	}
}

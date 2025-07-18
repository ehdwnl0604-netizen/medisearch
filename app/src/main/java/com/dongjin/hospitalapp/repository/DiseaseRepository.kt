package com.dongjin.hospitalapp.repository

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class DiseaseRepository @Inject constructor(
	private val firestore: FirebaseFirestore
) {
	suspend fun getDiseasesByCategory(category: String): List<String> =
		suspendCancellableCoroutine { cont ->
			firestore.collection("diseases")
				.whereEqualTo("category", category)
				.get()
				.addOnSuccessListener { snapshot ->
					val list = snapshot.documents.mapNotNull { it.getString("name") }
					cont.resume(list)
				}
				.addOnFailureListener {
					cont.resume(emptyList())
				}
		}

	suspend fun getDiseaseDescription(name: String): String? =
		suspendCancellableCoroutine { cont ->
			firestore.collection("diseases")
				.document(name)
				.get()
				.addOnSuccessListener { doc ->
					cont.resume(doc.getString("description"))
				}
				.addOnFailureListener {
					cont.resume(null)
				}
		}
}

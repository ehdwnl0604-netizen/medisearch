package com.dongjin.hospitalapp.repository

import com.dongjin.hospitalapp.data.CaregiverService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CaregiverRepository @Inject constructor(
	private val db: FirebaseFirestore
) {
	suspend fun getCaregiverServices(region: String): List<CaregiverService> {
		return try {
			val snapshot = db.collection("caregiver_services")
				.whereEqualTo("region", region)
				.get()
				.await()

			snapshot.documents.mapNotNull { it.toObject(CaregiverService::class.java) }
		} catch (e: Exception) {
			emptyList()
		}
	}
}

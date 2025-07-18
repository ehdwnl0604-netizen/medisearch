package com.dongjin.hospitalapp.repository

import com.dongjin.hospitalapp.data.Hospital
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HospitalRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun getHospitals(): List<Hospital> {
        return try {
            val snapshot = firestore.collection("hospitals").get().await()
            snapshot.documents.mapNotNull { it.toObject(Hospital::class.java) }
        } catch (e: Exception) {
            emptyList()
        }
    }
}

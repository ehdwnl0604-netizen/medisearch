package com.dongjin.hospitalapp.repository

import com.dongjin.hospitalapp.data.PolicyFund
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PolicyFundRepository @Inject constructor(
	private val db: FirebaseFirestore
) {
	suspend fun getPolicyFunds(): List<PolicyFund> {
		return try {
			val snapshot = db.collection("policy_funds").get().await()
			snapshot.documents.mapNotNull { it.toObject(PolicyFund::class.java) }
		} catch (e: Exception) {
			emptyList()
		}
	}
}

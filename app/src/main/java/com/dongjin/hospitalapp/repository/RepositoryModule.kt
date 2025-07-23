package com.dongjin.hospitalapp.repository

import com.dongjin.hospitalapp.data.GeocodingService
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    // ✅ Firestore는 Caregiver 등에서만 사용하므로 그대로 유지
    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    // ✅ Caregiver 등 Firestore 사용하는 리포지토리는 그대로 유지
    @Provides
    @Singleton
    fun provideCaregiverRepository(
        firestore: FirebaseFirestore
    ): CaregiverRepository {
        return CaregiverRepository(firestore)
    }

    @Provides
    @Singleton
    fun providePolicyFundRepository(
        firestore: FirebaseFirestore
    ): PolicyFundRepository {
        return PolicyFundRepository(firestore)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        firestore: FirebaseFirestore
    ): ProductRepository {
        return ProductRepository(firestore)
    }

    @Provides
    @Singleton
    fun provideGeocodingService(): GeocodingService {
        return GeocodingService()
    }

    @Provides
    @Singleton
    fun provideHospitalRepository(
        firestore: FirebaseFirestore,
        geocodingService: GeocodingService
    ): HospitalRepository {
        return HospitalRepository(firestore, geocodingService)
    }

}

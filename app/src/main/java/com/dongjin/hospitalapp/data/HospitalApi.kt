package com.dongjin.hospitalapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface HospitalApi {
    @GET("getHospBasisList")
    suspend fun getHospitals(
        @Query("ServiceKey", encoded = true) serviceKey: String,
        @Query("pageNo") pageNo: Int = 1,
        @Query("numOfRows") numOfRows: Int = 20,
        // 필요시 추가 Query
    ): HospitalResponse
}

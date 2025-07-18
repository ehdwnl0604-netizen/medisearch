package com.dongjin.hospitalapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

// HospitalResponse.kt
@Root(name = "response", strict = false)
data class HospitalResponse(
    @field:Element(name = "body")
    var body: HospitalBody? = null
)

@Root(name = "body", strict = false)
data class HospitalBody(
    @field:Element(name = "items")
    var items: HospitalItems? = null
)

@Root(name = "items", strict = false)
data class HospitalItems(
    @field:ElementList(inline = true, required = false)
    var item: List<Hospital>? = null
)

@Parcelize
data class Hospital(
    val name: String? = null,        // 병원명
    val type: String? = null,        // 병원 종류 (상급종합병원, 종합병원 등)
    val address: String? = null,     // 주소
    val tel: String? = null,         // 전화번호
    val url: String? = null,         // 홈페이지
    val subject: String? = null,     // 진료과목 (ex. 재활의학과)
    val sido: String? = null,        // 시도명 (서울특별시 등)
    val sggu: String? = null         // 시군구명 (강남구 등, 현재는 사용 안 함)
): Parcelable
package com.dongjin.hospitalapp.model

enum class HospitalType(val code: String, val displayName: String) {
    TERTIARY("01", "상급종합병원"),
    GENERAL("11", "종합병원"),
    LONG_TERM("28", "요양병원")
}

package com.dongjin.hospitalapp.util

object HospitalCodeMapper {
    fun getHospitalTypeCodes(selected: List<String>): List<String> = selected.map {
        when (it) {
            "상급종합병원" -> "ADV"
            "종합병원" -> "GEN"
            "요양병원" -> "NUR"
            "재활의학과병원" -> "REHAB"
            else -> ""
        }
    }.filter { it.isNotEmpty() }

    fun getTypeNameByCode(code: String): String = when (code) {
        "ADV" -> "상급종합"
        "GEN" -> "종합병원"
        "NUR" -> "요양병원"
        else -> ""
    }

    fun getRegionCodes(selected: List<String>): List<String> = selected

    fun getDepartmentCodes(selected: List<String>): List<String> {
        // 아직 질환 필터 안 쓰므로 빈 처리
        return emptyList()
    }
}

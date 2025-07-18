package com.dongjin.hospitalapp.data

object DiseaseData {
    val categoryMap: Map<String, List<Disease>> = mapOf(
        "감염성질환" to infectiousDiseases,
        "뇌신경정신질환" to neuroPsychDiseases,
        "신장비뇨기질환" to RenalUroDiseases,
        "종양혈액질환(암)" to CancerHematologicDiseases,
        "근골격질환" to MusculoskeletalDiseases,
        "소화기질환" to GastrointestinalDiseases,
        "호흡기질환" to RespiratoryDiseases,
        "순환기질환" to CardiovascularDiseases
        // 다른 카테고리도 계속 추가 가능
    )
}

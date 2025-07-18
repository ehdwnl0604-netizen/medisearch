package com.dongjin.hospitalapp.data

data class Disease(
    val id: String,
    val name: String,
    val englishName: String,
    val category: String,
    val symptoms: List<String>,
    val relatedDiseases: List<String>,
    val department: String,
    val synonyms: List<String>,
    val webUrl: String // 클릭 시 연결할 웹 URL
)

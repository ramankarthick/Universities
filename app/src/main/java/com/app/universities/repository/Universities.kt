package com.app.universities.repository

data class Universities(
    val alphaTwoCode: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val stateProvince: String,
    val webPages: List<String>
)
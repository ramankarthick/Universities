package com.app.universities.repository

import com.app.universities.service.UniversityApiService

class UniversityRepository(private val apiService: UniversityApiService) {
    suspend fun getUniversities(country: String): List<Universities> {
        return apiService.getUniversities(country)
    }
}
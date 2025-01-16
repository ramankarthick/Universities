package com.app.universities.repository

import com.app.universities.service.UniversityApiService
import javax.inject.Inject

class UniversityRepository @Inject constructor (private val apiService: UniversityApiService) {
    suspend fun getUniversities(country: String): List<Universities> {
        return apiService.getUniversities(country)
    }
}
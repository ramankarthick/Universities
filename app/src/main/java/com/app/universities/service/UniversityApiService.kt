package com.app.universities.service

import com.app.universities.repository.Universities
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {
    @GET("search")
    suspend fun getUniversities(
        @Query("country") country: String
    ): List<Universities>
}
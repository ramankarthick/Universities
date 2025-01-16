package com.app.universities.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.universities.model.UniversitiesViewModel
import javax.inject.Inject

class UniversityViewModelFactory @Inject constructor(
    private val repository: UniversityRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UniversitiesViewModel(repository) as T
    }
}
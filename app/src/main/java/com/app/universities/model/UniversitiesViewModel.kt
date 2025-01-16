package com.app.universities.model

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.universities.repository.Universities
import com.app.universities.repository.UniversityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UniversitiesViewModel @Inject constructor(private val repository: UniversityRepository): ViewModel() {

    private val _universities = mutableStateListOf<Universities>()
    val universities: List<Universities> get() = _universities

    init {
        getUniversities()
    }

    fun getUniversities() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.getUniversities("United States")
                }
                _universities.addAll(response.take(50))  // Limit to 50 universities
            } catch (e: Exception) {
                Log.e("Universities", "Printing error logs: $e")
            }
        }
    }

}
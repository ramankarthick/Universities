package com.app.universities.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.universities.repository.Universities
import com.app.universities.repository.UniversityRepository
import kotlinx.coroutines.launch

class UniversitiesViewModel(private val repository: UniversityRepository): ViewModel() {

    private val _universities = MutableLiveData<List<Universities>>()
    val universities: LiveData<List<Universities>> = _universities

    fun getUniversities() {
        viewModelScope.launch {
            val result = repository.getUniversities("United States")
            _universities.postValue(result.take(50))
        }
    }

}
package com.example.a65appstest.viewmodels

import androidx.lifecycle.ViewModel
import com.example.a65appstest.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmployeeInfoViewmodel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun getSpecialtiesByEmployeeID(id: Long) = repository.getSpecialtiesByEmployeeID(id)
}
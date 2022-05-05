package com.example.a65appstest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.a65appstest.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: Repository
) :  ViewModel(){
    val specialityWithEmployee = repository.getSpeciality().asLiveData()
}
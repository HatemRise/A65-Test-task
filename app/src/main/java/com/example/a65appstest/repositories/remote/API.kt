package com.example.a65appstest.repositories.remote

import com.example.a65appstest.repositories.entity_and_models.model.Response
import retrofit2.http.GET

interface API {
    companion object{
        const val BASE_URL = "http://gitlab.65apps.com"
    }

    @GET("/65gb/static/raw/master/testTask.json")
    suspend fun getEmployeesWithSpeciality() : Response
}
package com.example.a65appstest.repositories.entity_and_models.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(
    @SerializedName("response")
    @Expose
    val employeeWithSpecialityRaw: List<EmployeeWithSpecialityRaw>
) : Parcelable

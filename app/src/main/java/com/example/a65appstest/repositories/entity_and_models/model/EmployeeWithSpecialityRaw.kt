package com.example.a65appstest.repositories.entity_and_models.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeWithSpecialityRaw(
    @ColumnInfo(name = "first_name")
    @SerializedName("f_name")
    @Expose
    val firstName: String,
    @ColumnInfo(name = "last_name")
    @SerializedName("l_name")
    @Expose
    val lastName: String,
    @ColumnInfo(name = "birthday")
    @SerializedName("birthday")
    @Expose
    val birthday: String?,
    @ColumnInfo(name = "avatr_url")
    @SerializedName("avatr_url")
    @Expose
    val avatarURL: String,
    @SerializedName("specialty")
    @Expose
    val specialtyList: List<Specialty>
) : Parcelable

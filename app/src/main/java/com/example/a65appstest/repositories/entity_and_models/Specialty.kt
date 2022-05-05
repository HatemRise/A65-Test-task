package com.example.a65appstest.repositories.entity_and_models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "speciality")
@Parcelize
data class Specialty(
    @PrimaryKey
    @ColumnInfo("id")
    @SerializedName("specialty_id")
    @Expose
    val id: Long? = null,
    @ColumnInfo("name")
    @SerializedName("name")
    @Expose
    val name: String
) : Parcelable
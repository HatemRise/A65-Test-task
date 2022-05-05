package com.example.a65appstest.repositories.entity_and_models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Entity(tableName = "employee")
@Parcelize
data class Employee(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long? = null,
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
    val avatarURL: String?
) : Parcelable {
    fun getAge() = if (birthday != "-") {
            val now = LocalDate.now()
            val birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            ChronoUnit.YEARS.between(birthday, now).toString()
        } else {
            birthday
        }
}
package com.example.a65appstest.repositories.entity_and_models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "employee_speciality",
    foreignKeys = [
        ForeignKey(entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["employee_id"]
        ),
        ForeignKey(entity = Specialty::class,
            parentColumns = ["id"],
            childColumns = ["speciality_id"]
        )
    ]
)
@Parcelize
data class EmployeeSpeciality(
    @PrimaryKey
    val id: Long? = null,
    @ColumnInfo("employee_id")
    val empId: Long,
    @ColumnInfo("speciality_id")
    val specId: Long
) : Parcelable

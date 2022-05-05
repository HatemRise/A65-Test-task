package com.example.a65appstest.repositories.entity_and_models.relation

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeInSpeciality(
    @Embedded val employeeSpeciality: EmployeeSpeciality,
    @Relation(
        parentColumn = "employee_id",
        entityColumn = "id",
        entity = Employee::class
    )
    val employee: Employee
) : Parcelable

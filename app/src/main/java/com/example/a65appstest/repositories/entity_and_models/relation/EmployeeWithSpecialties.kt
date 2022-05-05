package com.example.a65appstest.repositories.entity_and_models.relation

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import com.example.a65appstest.repositories.entity_and_models.Specialty
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeWithSpecialties(
    @Embedded
    val employeeSpeciality: EmployeeSpeciality,
    @Relation(
        parentColumn = "speciality_id",
        entityColumn = "id",
        entity = Specialty::class
    )
    val specialty: Specialty
) : Parcelable

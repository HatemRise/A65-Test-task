package com.example.a65appstest.repositories.entity_and_models.relation

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import com.example.a65appstest.repositories.entity_and_models.Specialty
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpecialityWithEmployee(
    @Embedded val specialty: Specialty,
    @Relation(
        parentColumn = "id",
        entityColumn = "speciality_id",
        entity = EmployeeSpeciality::class
    )
    val specialityEmployee: List<EmployeeInSpeciality>
) : Parcelable
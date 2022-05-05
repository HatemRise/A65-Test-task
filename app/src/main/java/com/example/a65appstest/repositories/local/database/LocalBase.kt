package com.example.a65appstest.repositories.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.repositories.local.EmployeeDAO

@Database(
    entities = [Employee::class, EmployeeSpeciality::class, Specialty::class],
    version = 1, exportSchema = false
)
abstract class LocalBase : RoomDatabase() {
    abstract fun dao() : EmployeeDAO
}
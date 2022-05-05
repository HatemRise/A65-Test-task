package com.example.a65appstest.repositories.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.repositories.entity_and_models.relation.EmployeeWithSpecialties
import com.example.a65appstest.repositories.entity_and_models.relation.SpecialityWithEmployee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM speciality")
    fun getSpecialityWithEmployees() : Flow<List<SpecialityWithEmployee>>

    @Query("SELECT * FROM employee_speciality WHERE employee_id LIKE :id")
    fun getSpecialtiesByEmployeeID(id: Long) : Flow<List<EmployeeWithSpecialties>>



    @Query("DELETE FROM employee")
    suspend fun removeAllEmployees()

    @Query("DELETE FROM employee_speciality")
    suspend fun removeAllEmployeeSpeciality()

    @Query("DELETE FROM speciality")
    suspend fun removeAllSpeciality()



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: Employee) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpeciality(specialty: Specialty) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployeeSpeciality(employeeSpeciality: EmployeeSpeciality) : Long

}
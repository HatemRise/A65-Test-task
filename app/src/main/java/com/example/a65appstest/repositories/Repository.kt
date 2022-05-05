package com.example.a65appstest.repositories

import androidx.room.withTransaction
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.EmployeeSpeciality
import com.example.a65appstest.repositories.local.database.LocalBase
import com.example.a65appstest.repositories.remote.API
import com.example.a65appstest.util.networkBoundResource
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val db: LocalBase,
    private val api: API
) {
    private val dao = db.dao()

    fun getSpeciality() = networkBoundResource(
        query = {
            dao.getSpecialityWithEmployees()
        },
        fetch = {
            api.getEmployeesWithSpeciality().employeeWithSpecialityRaw
        },
        saveFetchResult = {
            db.withTransaction{
                dao.removeAllEmployeeSpeciality()
                dao.removeAllSpeciality()
                dao.removeAllEmployees()
                it.forEach { employee ->
                    var birthday = "-"
                    if (!employee.birthday.isNullOrBlank()){
                        val format = DateTimeFormatterBuilder().parseCaseSensitive()
                            .appendPattern("[dd-MM-yyyy]")
                            .appendPattern("[yyyy-MM-dd]")
                            .toFormatter()
                        val date = LocalDate.parse(employee.birthday, format)
                        birthday = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                    }
                    val employeeID = dao.insertEmployee(Employee(
                        firstName = employee.firstName.lowercase(Locale.getDefault())
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                        lastName = employee.lastName.lowercase(Locale.getDefault())
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                        birthday = birthday,
                        avatarURL = employee.avatarURL
                    ))
                    employee.specialtyList.forEach { speciality ->
                        val specialityID = dao.insertSpeciality(speciality)
                        dao.insertEmployeeSpeciality(EmployeeSpeciality(
                            empId = employeeID,
                            specId = specialityID
                        ))
                    }
                }
            }
        }
    )

    fun getSpecialtiesByEmployeeID(id: Long) = dao.getSpecialtiesByEmployeeID(id)
}
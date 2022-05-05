package com.example.a65appstest.view.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a65appstest.R
import com.example.a65appstest.databinding.EmployeeInfoFragmentBinding
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.view.components.adapters.SpecialtyAdapter
import com.example.a65appstest.viewmodels.EmployeeInfoViewmodel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@AndroidEntryPoint
class EmployeeInfoFragment : Fragment(R.layout.employee_info_fragment) {

    private var _binding: EmployeeInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<EmployeeInfoFragmentArgs>()
    private lateinit var employee: Employee

    private val viewmodel: EmployeeInfoViewmodel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = EmployeeInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        employee = args.employee
        binding.apply {
            lastName.text = employee.lastName
            firstName.text = employee.firstName
            birthday.text = employee.birthday
            age.text = employee.getAge()
            val adapter = SpecialtyAdapter()
            viewmodel.getSpecialtiesByEmployeeID(employee.id!!).asLiveData().observe(requireActivity()){
                adapter.submitList(it)
            }
            specialty.apply {
                layoutManager = LinearLayoutManager(requireContext())
                this.adapter = adapter
            }
        }
    }
}
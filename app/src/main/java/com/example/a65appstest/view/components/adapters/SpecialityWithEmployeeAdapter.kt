package com.example.a65appstest.view.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a65appstest.databinding.SpecialityItemTemplateBinding
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.repositories.entity_and_models.relation.SpecialityWithEmployee

class SpecialityWithEmployeeAdapter(private val listener: OnClick) : ListAdapter<SpecialityWithEmployee, SpecialityWithEmployeeAdapter.SpecialityWithEmployeeHolder>(
    SpecialityComparator()
) {
    fun interface OnClick {
        fun onClick(employee: Employee)
    }

    inner class SpecialityWithEmployeeHolder(private val binding: SpecialityItemTemplateBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.apply {
                headerTitle.setOnClickListener {
                    employeeList.isVisible = !employeeList.isVisible
                }
            }
        }

        fun bind(specialityWithEmployee: SpecialityWithEmployee){
            binding.apply {
                headerTitle.text = specialityWithEmployee.specialty.name
                val employeeAdapter = EmployeeAdapter(listener).apply {
                    submitList(specialityWithEmployee.specialityEmployee.map { it.employee })
                }
                employeeList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = employeeAdapter
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpecialityWithEmployeeHolder(
        SpecialityItemTemplateBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false
        )
    )

    override fun onBindViewHolder(holder: SpecialityWithEmployeeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SpecialityComparator : DiffUtil.ItemCallback<SpecialityWithEmployee>() {
        override fun areItemsTheSame(oldItem: SpecialityWithEmployee, newItem: SpecialityWithEmployee) = oldItem.specialty.id == newItem.specialty.id

        override fun areContentsTheSame(oldItem: SpecialityWithEmployee, newItem: SpecialityWithEmployee) = oldItem == newItem

    }
}
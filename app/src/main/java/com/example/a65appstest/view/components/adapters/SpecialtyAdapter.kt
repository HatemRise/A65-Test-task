package com.example.a65appstest.view.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a65appstest.databinding.EmployeeListItemBinding
import com.example.a65appstest.databinding.SpecialityItemTemplateBinding
import com.example.a65appstest.databinding.SpecialtyItemTemplateBinding
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.repositories.entity_and_models.relation.EmployeeWithSpecialties

class SpecialtyAdapter : ListAdapter<EmployeeWithSpecialties, SpecialtyAdapter.SpecialtyHolder>(
    EmployeeComparator()
) {

    inner class SpecialtyHolder(private val binding: SpecialtyItemTemplateBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(employeeWithSpecialties: EmployeeWithSpecialties){
            binding.apply {
                name.text = employeeWithSpecialties.specialty.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpecialtyHolder(
        SpecialtyItemTemplateBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: SpecialtyHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EmployeeComparator : DiffUtil.ItemCallback<EmployeeWithSpecialties>(){
        override fun areItemsTheSame(oldItem: EmployeeWithSpecialties, newItem: EmployeeWithSpecialties) = oldItem.specialty.id == oldItem.specialty.id

        override fun areContentsTheSame(oldItem: EmployeeWithSpecialties, newItem: EmployeeWithSpecialties) = oldItem.specialty == oldItem.specialty
    }
}
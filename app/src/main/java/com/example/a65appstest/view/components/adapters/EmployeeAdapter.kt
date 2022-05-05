package com.example.a65appstest.view.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a65appstest.databinding.EmployeeListItemBinding
import com.example.a65appstest.repositories.entity_and_models.Employee
import com.example.a65appstest.repositories.entity_and_models.Specialty
import com.example.a65appstest.view.components.adapters.SpecialityWithEmployeeAdapter.OnClick
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class EmployeeAdapter(private val listener: OnClick) : ListAdapter<Employee, EmployeeAdapter.EmployeeHolder>(
    EmployeeComparator()
) {

    inner class EmployeeHolder(private val binding: EmployeeListItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener.onClick(getItem(adapterPosition))
            }
        }

        fun bind(employee: Employee){
            binding.apply {
                firstName.text = employee.firstName
                lastName.text = employee.lastName
                age.text = employee.getAge()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EmployeeHolder(
        EmployeeListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EmployeeComparator : DiffUtil.ItemCallback<Employee>(){
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee) = oldItem == newItem
    }
}
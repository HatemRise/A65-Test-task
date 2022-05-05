package com.example.a65appstest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a65appstest.R
import com.example.a65appstest.databinding.MainScreenFragmentBinding
import com.example.a65appstest.view.components.adapters.SpecialityWithEmployeeAdapter
import com.example.a65appstest.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment(R.layout.main_screen_fragment) {

    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SpecialityWithEmployeeAdapter{
            val action = MainScreenFragmentDirections.actionMainScreenFragmentToEmployeeInfoFragment(it)
            findNavController().navigate(action)
        }
        viewModel.specialityWithEmployee.observe(requireActivity()) {
            adapter.submitList(it.data)
        }
        binding.apply {
            specialityList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                this.adapter = adapter
            }
        }
    }
}
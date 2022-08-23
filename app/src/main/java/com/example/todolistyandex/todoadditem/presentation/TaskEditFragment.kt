package com.example.todolistyandex.todoadditem.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.todolistyandex.R
import com.example.todolistyandex.databinding.FragmentTaskEditBinding

class TaskEditFragment : Fragment() {

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(layoutInflater)
        val view = binding.root

        binding.closeBut.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.saveBut.setOnClickListener {
            //viewModel!!.addTask(extractTask())
            viewModel!!.insert(extractTask())
            it.findNavController().navigateUp()
        }

        binding.deleteBut.setOnClickListener {
            it.findNavController().navigateUp()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
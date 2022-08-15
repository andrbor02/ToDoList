package com.example.todolistyandex.todoadditem.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.todolistyandex.R
import com.example.todolistyandex.databinding.FragmentTodoItemEditBinding

class TodoItemEditFragment : Fragment() {

    private lateinit var binding: FragmentTodoItemEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoItemEditBinding.inflate(layoutInflater)
        val view = binding.root

        binding.closeBut.setOnClickListener {
            it.findNavController().navigate(R.id.edit_to_list)
        }

        binding.saveBut.setOnClickListener {
            it.findNavController().navigate(R.id.edit_to_list)
        }

        binding.deleteBut.setOnClickListener {
            it.findNavController().navigate(R.id.edit_to_list)
        }

        return view
    }
}
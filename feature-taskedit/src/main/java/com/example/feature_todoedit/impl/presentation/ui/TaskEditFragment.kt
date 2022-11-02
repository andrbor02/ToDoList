package com.example.feature_todoedit.impl.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding
import com.example.feature_todoedit.impl.di.TaskEditComponentHolder
import com.example.feature_todoedit.impl.domain.utils.PriorityChecker
import com.example.feature_todoedit.impl.domain.utils.TaskExtractor
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModel
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModelFactory
import javax.inject.Inject

class TaskEditFragment : Fragment() {

    lateinit var extractor: TaskExtractor

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var taskEditViewModelFactory: TaskEditViewModelFactory

    private val viewModel: TaskEditViewModel by viewModels {
        taskEditViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(layoutInflater)
        val view = binding.root

        TaskEditComponentHolder.getComponent().inject(this)

        extractor = TaskExtractor(PriorityChecker(), binding)

        setUpListeners()
        return view
    }

    private fun setUpListeners() {
        binding.closeBut.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveBut.setOnClickListener {
            val newTask = extractor.extract()
            viewModel.insert(newTask)
            findNavController().navigateUp()

        }

        binding.deleteBut.setOnClickListener {
//            val curTask = extractor.extract()
//            viewModel.delete(curTask)
            findNavController().navigateUp()
        }
    }

    override fun onPause() {
        super.onPause()
        TaskEditComponentHolder.reset()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
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
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModel
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModelFactory
import javax.inject.Inject

class TaskEditFragment : Fragment() {

//    @Inject
//    lateinit var hardcodedTaskDataSource: HardcodedTaskDataSource

//    @Inject
//    lateinit var loggerTaskDataSource: LoggerTaskDataSource
//
//    @Inject
//    lateinit var repository: TaskRepository

    lateinit var extractor: TaskExtractor

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var taskEditViewModelFactory: TaskEditViewModelFactory

    private val viewModel: TaskEditViewModel by viewModels {
        taskEditViewModelFactory
//        TaskEditViewModelFactory(
////            (activity?.application as App).repository
//            //hardcodedTaskDataSource
//            loggerTaskDataSource,
//            repository
//        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(layoutInflater)
        val view = binding.root

        TaskEditComponentHolder.getComponent().inject(this)
        extractor = TaskExtractor(binding)

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
            viewModel.getHard()
            findNavController().navigateUp()

        }
//
//        binding.deleteBut.setOnClickListener {
//            it.findNavController().navigateUp()
//        }
    }

//    private fun identifyPriority(): TaskPriority {
//        return when (binding.taskPriority.text.toString()) {
//            TaskPriority.None.title -> TaskPriority.None
//            TaskPriority.Low.title -> TaskPriority.Low
//            TaskPriority.High.title -> TaskPriority.High
//            else -> throw IllegalArgumentException("No such priority state!")
//        }
////        TODO move this logic to domain
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        TaskEditComponentHolder.reset() // TODO move to onPause
    }

}
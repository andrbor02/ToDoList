package com.example.todolistyandex.todoedit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.todolistyandex.app.App
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.app.domain.model.TaskPriority
import com.example.todolistyandex.databinding.FragmentTaskEditBinding
import com.example.todolistyandex.todoedit.presentation.stateholders.TaskEditViewModel
import com.example.todolistyandex.todoedit.presentation.stateholders.TaskEditViewModelFactory
import java.util.*

class TaskEditFragment : Fragment() {

    private var _binding: FragmentTaskEditBinding? = null
    private val binding get() = _binding!!

//    @Inject
//    lateinit var taskEditViewModelFactory: TasksListViewModelFactory

    private val viewModel: TaskEditViewModel by viewModels {
        //taskEditViewModelFactory
        TaskEditViewModelFactory(
            (activity?.application as App).repository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(layoutInflater)
        val view = binding.root

        setUpListeners()

        return view
    }

    fun setUpListeners() {
        binding.closeBut.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.saveBut.setOnClickListener {
            viewModel.insert(extractTask())
            it.findNavController().navigateUp()
        }

        binding.deleteBut.setOnClickListener {
            it.findNavController().navigateUp()
        }
    }

    private fun extractTask(): Task {
        val taskName = binding.taskDescription.text.toString()
        //val taskPriority = identifyPriority()
        val taskDeadline = binding.taskDeadline.text.toString()

        return Task(
            "0",
            taskName,
            TaskPriority.None,
            taskDeadline,
            false,
            Calendar.getInstance().time.toString()
        )
    }

    private fun identifyPriority(): TaskPriority {
        return when (binding.taskPriority.text.toString()) {
            TaskPriority.None.title -> TaskPriority.None
            TaskPriority.Low.title -> TaskPriority.Low
            TaskPriority.High.title -> TaskPriority.High
            else -> throw IllegalArgumentException("No such priority state!")
        }
//        TODO move this logic to domain
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.feature_todoedit.impl.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import com.example.core_utils.datawrappers.Result
import com.example.feature_todoedit.R
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding
import com.example.feature_todoedit.impl.di.TaskEditComponentHolder
import com.example.feature_todoedit.impl.domain.utils.TaskExtractor
import com.example.feature_todoedit.impl.domain.utils.TaskMerger
import com.example.feature_todoedit.impl.domain.utils.deadline.DeadlineController
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModel
import com.example.feature_todoedit.impl.presentation.stateholders.TaskEditViewModelFactory
import javax.inject.Inject

class TaskEditFragment : Fragment() {

    private lateinit var extractor: TaskExtractor
    private lateinit var deadlineController: DeadlineController

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

        extractor = TaskExtractor(binding)
        deadlineController = DeadlineController(
            context = requireContext(),
            binding = binding
        )

        checkIfTaskExists()
        setUpListeners()
        return view
    }

    private fun checkIfTaskExists() {
        val argsKey = resources.getString(R.string.task_id)
        val argsValue = arguments?.getString(argsKey) ?: ""
        if (argsValue != "") {
            Log.e("MMM", "Existing task id: $argsValue")
            setExistingTask(taskId = argsValue)
        }
    }

    private fun setUpListeners() {
        binding.priorityBut.setOnClickListener {
            showPriorityMenu()
        }

        binding.deadlineBut.setOnClickListener {
            showDatePicker()
        }

        binding.closeBut.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveBut.setOnClickListener {
            viewModel.apply {
                val extractedTask = extractor.extract()

                if (currentTaskLD.value == null) {
                    insert(extractedTask)
                } else {
                    currentTaskLD.value?.map { task ->
                        val merger = TaskMerger(
                            extractedTask = extractedTask,
                            currentTask = task
                        )
                        val editedTask = merger.merge()
                        update(editedTask)
                    }
                }
            }

            findNavController().navigateUp()

        }

        binding.deleteBut.setOnClickListener {
            val curTask = viewModel.currentTaskLD.value
            curTask?.map { task ->
                viewModel.delete(task)
            }
            findNavController().navigateUp()
        }
    }

    private fun setExistingTask(taskId: String) {
        viewModel.getById(taskId)
        viewModel.currentTaskLD.observe(viewLifecycleOwner) { task ->
            when (task) {
                is Result.Success -> expandExistingTask(task.value)
                is Result.Error -> TODO()
            }
        }
    }

    private fun showDatePicker() {
        deadlineController.changeDeadline()
    }

    private fun expandExistingTask(task: Task) {
        binding.taskDescription.setText(task.description)
        binding.taskPriority.text = task.priority.title
        binding.taskDeadline.text = task.deadline
    }

    private fun showPriorityMenu() {
        val menu = PopupMenu(context, binding.priorityBut)
        menu.inflate(R.menu.menu_priority)
        menu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.priority_none -> {
                    binding.taskPriority.text = TaskPriority.None.title
                    true
                }
                R.id.priority_low -> {
                    binding.taskPriority.text = TaskPriority.Low.title
                    true
                }
                R.id.priority_high -> {
                    binding.taskPriority.text = TaskPriority.High.title
                    true
                }
                else -> false
            }
        }
        menu.show()
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
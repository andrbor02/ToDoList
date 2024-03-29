package com.example.feature_tasklist.impl.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core_model.Task
import com.example.feature_tasklist.R
import com.example.feature_tasklist.databinding.FragmentTasksListBinding
import com.example.feature_tasklist.impl.di.TaskListComponentHolder
import com.example.feature_tasklist.impl.presentation.navigation.TasksListNavigation
import com.example.feature_tasklist.impl.presentation.stateholders.TasksListViewModel
import com.example.feature_tasklist.impl.presentation.stateholders.TasksListViewModelFactory
import com.example.todolistyandex.todolist.presentation.recycler.TaskClickListener
import com.example.todolistyandex.todolist.presentation.recycler.TasksListAdapter
import com.example.todolistyandex.todolist.presentation.recycler.TasksListDiffUtil
import javax.inject.Inject


class TasksListFragment : Fragment(), TaskClickListener {

    private val binding: FragmentTasksListBinding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentTasksListBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var tasksListViewModelFactory: TasksListViewModelFactory

    @Inject
    lateinit var navigation: TasksListNavigation

    private val viewModel: TasksListViewModel by viewModels {
        tasksListViewModelFactory
    }

    private var adapter: TasksListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root

        TaskListComponentHolder.getComponent().inject(this)

        setUpRecycler()
        setUpListeners()
        setUpObservers()

        return view
    }

    private fun setUpRecycler() {

        val tasksRecyclerView = binding.todoRecyclerView
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)

        val tasksListDiffUtil = TasksListDiffUtil()
        adapter = TasksListAdapter(
            tasksListDiffUtil,
            this
        )
        tasksRecyclerView.adapter = adapter
    }

    private fun setUpListeners() {

        binding.fab.setOnClickListener {
            navigation.addNewTask()
        }

        binding.newTaskRecyclerViewBut.setOnClickListener {
            navigation.addNewTask()
        }

        binding.toggleVisibility.setOnClickListener {
            viewModel.changeCompletedVisibility()
        }
    }

    private fun setUpObservers() {
        viewModel.showCompletedLD.observe(viewLifecycleOwner) { isShown ->
            val visibilityOn = AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.ic_visibility_on
            )
            val visibilityOff = AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.ic_visibility_off
            )
            if (isShown) {
                binding.toggleVisibility.setImageDrawable(visibilityOn)
            } else {
                binding.toggleVisibility.setImageDrawable(visibilityOff)
            }
        }

        viewModel.taskListLD.observe(viewLifecycleOwner) { newList ->
            newList.let { adapter?.submitList(it) }
        }

        viewModel.completedTasksNumberLD.observe(viewLifecycleOwner) { completedNumber ->
            val counterLabel = getString(R.string.completed_counter_label)
            val newCounter = "$counterLabel $completedNumber"

            binding.completedCounter.text = newCounter
        }
    }

    override fun onItemClick(task: Task) {
        Log.e("MMM", "onItemClick: ${task}")
        navigation.editExistingTask(task.id)
    }

    override fun onCheckboxClick(task: Task, isCompleted: Boolean) {
        viewModel.changeTaskCompletion(task, isCompleted)
    }

    override fun onDestroy() {
        super.onDestroy()
        TaskListComponentHolder.reset()
    }
}
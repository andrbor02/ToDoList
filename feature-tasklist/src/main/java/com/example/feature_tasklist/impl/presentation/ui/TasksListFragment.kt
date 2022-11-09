package com.example.feature_tasklist.impl.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private var _binding: FragmentTasksListBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentTasksListBinding.inflate(layoutInflater)
        val view = binding.root

        TaskListComponentHolder.getComponent().inject(this)

        setUpRecycler()
        setUpListeners()

        viewModel.taskListLD.observe(viewLifecycleOwner) { newList ->
            newList.let { adapter?.submitList(it) }
            updateCompletedCounter(newList)
        }

        return view
    }

    private fun setUpListeners() {

        binding.fab.setOnClickListener {
            navigation.addNewTask()
        }

        binding.newTaskRvBut.setOnClickListener {
            navigation.addNewTask()
        }

        // TODO: make completed tasks invisible
//        binding.toggleVisibility.setOnClickListener {
//            it.foreground = resources.getDrawable(
//                R.drawable.ic_visibility_off
//            )
//        }

        binding.imageSwitcher.setOnClickListener {
            viewModel.visibilityChanged()
        }
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

    override fun onItemClick(task: Task) {
        Log.e("MMM", "onItemClick: ${task}")
        navigation.editExistingTask(task.id)
    }

    override fun onCheckboxClick(task: Task, isCompleted: Boolean) {
        viewModel.changeTaskCompletion(task, isCompleted)
    }

    private fun updateCompletedCounter(taskList: List<Task>) {
        val countCompleted = taskList.filter { task ->
            task.completion == true
        }.size

        val counterLabel = getString(R.string.completed_counter_label)
        val newCounter = "$counterLabel $countCompleted"

        binding.completedCounter.text = newCounter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        TaskListComponentHolder.reset()
    }
}
package com.example.todolistyandex.todolist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistyandex.R
import com.example.todolistyandex.app.App
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.databinding.FragmentTasksListBinding
import com.example.todolistyandex.todolist.presentation.recycler.TaskClickListener
import com.example.todolistyandex.todolist.presentation.recycler.TasksListAdapter
import com.example.todolistyandex.todolist.presentation.recycler.TasksListDiffUtil
import com.example.todolistyandex.todolist.presentation.stateholders.TasksListViewModel
import com.example.todolistyandex.todolist.presentation.stateholders.TasksListViewModelFactory
import javax.inject.Inject


class TasksListFragment : Fragment(), TaskClickListener {

    private var _binding: FragmentTasksListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var tasksListViewModelFactory: TasksListViewModelFactory

    private val viewModel: TasksListViewModel by viewModels {
        tasksListViewModelFactory
    }

    private var adapter: TasksListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).appComponent.injectToListFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksListBinding.inflate(layoutInflater)
        val view = binding.root

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
            it.findNavController().navigate(R.id.list_to_edit)
        }
        binding.newTaskRvBut.setOnClickListener {
            it.findNavController().navigate(R.id.list_to_edit)
        }

//        binding.toggleVisibility.setOnClickListener {
//            it.foreground = resources.getDrawable(
//                R.drawable.ic_visibility_off
//            )
//        }

        binding.imageSwitcher.setOnClickListener {
            // TODO: make visibility icons switch
            viewModel.visibilityChanged()
        }
    }

    private fun goToTaskDetails(task: Task) {
        findNavController().navigate(R.id.list_to_edit)
        // TODO: send task to edit fragment without direct connection between feature packages
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(task: Task) {
        goToTaskDetails(task)
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
}
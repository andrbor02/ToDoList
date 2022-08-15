package com.example.todolistyandex.todolist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistyandex.R
import com.example.todolistyandex.databinding.FragmentScrollingBinding
import com.example.todolistyandex.todolist.data.repository.TodoItemsRepositoryImpl
import com.example.todolistyandex.todolist.presentation.recycler.TasksListAdapter
import com.example.todolistyandex.todolist.presentation.recycler.TasksListDiffUtil


class TasksListFragment : Fragment() {

    private lateinit var binding: FragmentScrollingBinding

    private lateinit var tasksRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScrollingBinding.inflate(layoutInflater)
        val view = binding.root

        setUpRecycler()

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.list_to_edit)
        }

        return view
    }

    fun setUpRecycler() {

        val viewModel = TasksListViewModel()
        val tasksListDiffUtil = TasksListDiffUtil()

        val repo = TodoItemsRepositoryImpl()

        val todoItemsList = repo.getTodoItemsList()

        tasksRecyclerView = binding.todoRecyclerView
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)
        tasksRecyclerView.adapter = TasksListAdapter(viewModel, tasksListDiffUtil, todoItemsList)
    }
}
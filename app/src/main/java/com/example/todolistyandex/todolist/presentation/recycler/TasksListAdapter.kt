package com.example.todolistyandex.todolist.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todolistyandex.databinding.TaskItemBinding
import com.example.todolistyandex.todolist.presentation.TasksListViewModel
import com.example.todolistyandex.todolist.presentation.model.Task

class TasksListAdapter(
    private val viewModel: TasksListViewModel,
    tasksListDiffUtil: TasksListDiffUtil,
    private val tasks: ArrayList<Task>
    ) :
    ListAdapter<Task, TasksListViewHolder>(tasksListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTaskBinding = TaskItemBinding.inflate(layoutInflater, parent, false)

        return TasksListViewHolder(viewModel, itemTaskBinding)
    }

    override fun onBindViewHolder(holder: TasksListViewHolder, position: Int) {
        holder.bindTask(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
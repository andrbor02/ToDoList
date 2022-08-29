package com.example.todolistyandex.todolist.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.databinding.TaskItemBinding

class TasksListAdapter(
    tasksListDiffUtil: TasksListDiffUtil,
    private val taskClickListener: TaskClickListener
) :
    ListAdapter<Task, TasksListViewHolder>(tasksListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTaskBinding = TaskItemBinding.inflate(layoutInflater, parent, false)

        return TasksListViewHolder(itemTaskBinding)
    }

    override fun onBindViewHolder(holder: TasksListViewHolder, position: Int) {
        holder.bindTask(getItem(position), taskClickListener)
    }
}
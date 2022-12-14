package com.example.todolistyandex.todolist.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_model.Task
import com.example.feature_tasklist.databinding.TaskItemBinding
import com.example.feature_tasklist.impl.presentation.recycler.TasksListViewHolder

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
package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.todolistyandex.app.domain.model.Task

class TasksListDiffUtil : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}
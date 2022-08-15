package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.todolistyandex.todolist.presentation.model.TodoItem

class TasksListDiffUtil : DiffUtil.ItemCallback<TodoItem>() {
    override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem == newItem
    }
}
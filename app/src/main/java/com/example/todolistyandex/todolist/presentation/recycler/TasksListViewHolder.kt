package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.todolistyandex.databinding.TodoItemBinding
import com.example.todolistyandex.todolist.presentation.TasksListViewModel
import com.example.todolistyandex.todolist.presentation.model.TodoItem

class TasksListViewHolder(
    viewModel: TasksListViewModel,
    private val binding: TodoItemBinding
) : RecyclerView.ViewHolder(binding.root) {



    fun bindTask(todoItem: TodoItem) {
        binding.taskName.text = todoItem.text
        binding.taskDate.text = todoItem.deadline
    }
}
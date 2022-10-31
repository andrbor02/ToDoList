package com.example.todolistyandex.todolist.presentation.recycler

import com.example.core_model.Task


interface TaskClickListener {
    fun onItemClick(task: Task)

    fun onCheckboxClick(task: Task, isCompleted: Boolean)
}
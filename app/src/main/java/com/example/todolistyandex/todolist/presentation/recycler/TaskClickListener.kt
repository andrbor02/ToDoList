package com.example.todolistyandex.todolist.presentation.recycler

import com.example.todolistyandex.app.domain.model.Task

interface TaskClickListener {
    fun onItemClick(task: Task)

    fun onCheckboxClick(task: Task, isCompleted: Boolean)
}
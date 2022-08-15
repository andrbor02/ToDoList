package com.example.todolistyandex.todolist.domain.repository

import com.example.todolistyandex.todolist.presentation.model.Task

interface TaskRepository {

    fun add(task: Task)

    fun delete(id: String)
}
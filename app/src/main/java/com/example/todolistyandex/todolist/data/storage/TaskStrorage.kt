package com.example.todolistyandex.todolist.data.storage

import com.example.todolistyandex.todolist.presentation.model.Task

interface TaskStrorage {

    fun saveTasksList(todoList: ArrayList<Task>)

    fun getTasksList(): ArrayList<Task>
}
package com.example.todolistyandex.data.datasource

import com.example.todolistyandex.app.domain.model.Task

interface TaskDataSource {

    fun saveTaskList(taskList: List<Task>)

    fun getTasksList(): List<Task>
}
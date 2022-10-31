package com.example.core_data.api

import com.example.core_model.Task

interface TaskDataSource {

    fun saveTaskList(taskList: List<Task>)

    fun getTasksList(): List<Task>
}
package com.example.feature_tasklist.impl.presentation.navigation

interface TasksListNavigation {
    fun addNewTask()

    fun editExistingTask(taskId: Long)
}
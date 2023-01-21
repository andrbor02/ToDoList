package com.example.core_database.impl.datasource

import com.example.core_data.impl.model.DatabaseTask

interface TaskDataSource : ReadOnlyTaskDataSource {

    suspend fun insertTask(task: DatabaseTask)

    suspend fun updateTask(task: DatabaseTask)

    suspend fun deleteTask(taskId: Long)
}
package com.example.core_data.api

import com.example.core_model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    val taskList: Flow<List<Task>>

    suspend fun insert(task: Task)

    suspend fun update(task: Task)

    suspend fun delete(id: String)

    fun get(): Flow<List<Task>>
}
package com.example.core_data.api

import com.example.core_model.Task
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun insert(task: Task)

    suspend fun update(task: Task)

    suspend fun delete(id: Long)

    fun getAll(): Flow<List<Task>>

    fun getById(id: Long): Flow<Result<Task>>
}
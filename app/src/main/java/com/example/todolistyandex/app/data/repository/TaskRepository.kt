package com.example.todolistyandex.app.data.repository

import com.example.todolistyandex.app.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    val taskList: Flow<List<Task>>

    suspend fun insert(task: Task)

    suspend fun update(task: Task)

    fun delete(id: String)

    fun get(): Flow<List<Task>>
}
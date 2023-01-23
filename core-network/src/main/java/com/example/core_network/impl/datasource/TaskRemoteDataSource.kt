package com.example.core_network.impl.datasource

import com.example.core_network.impl.model.NetworkTaskWithId


interface TaskRemoteDataSource : ReadOnlyTaskRemoteDataSource, SyncTaskListRemoteDataSource {

    suspend fun insertTask(task: NetworkTaskWithId)

    suspend fun updateTask(task: NetworkTaskWithId)

    suspend fun deleteTask(taskId: Long)
}
package com.example.core_network.impl.datasource

import com.example.core_network.impl.model.NetworkTask
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow

interface ReadOnlyTaskRemoteDataSource {

    suspend fun getTaskList(): Flow<Result<List<NetworkTask>>>

    suspend fun getTaskById(taskId: Long): Flow<Result<NetworkTask>>
}
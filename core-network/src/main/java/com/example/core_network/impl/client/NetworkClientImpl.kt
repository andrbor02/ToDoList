package com.example.core_network.impl.client

import com.example.core_network.impl.datasource.TaskRemoteDataSource
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(
    private val taskRemoteDataSource: TaskRemoteDataSource
) : NetworkClient {

    override fun getTaskRemoteDataSource(): TaskRemoteDataSource {
        return taskRemoteDataSource
    }
}
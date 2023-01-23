package com.example.core_network.impl.client

import com.example.core_network.impl.datasource.TaskRemoteDataSource

interface NetworkClient {

    fun getTaskRemoteDataSource(): TaskRemoteDataSource
}
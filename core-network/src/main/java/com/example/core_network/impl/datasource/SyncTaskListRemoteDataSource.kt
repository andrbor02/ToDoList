package com.example.core_network.impl.datasource

import com.example.core_network.impl.model.NetworkTask

interface SyncTaskListRemoteDataSource {

    fun synchronizeTaskList(map: Map<String, NetworkTask>)
}
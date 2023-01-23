package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_model.Task
import com.example.core_network.impl.model.NetworkTask
import com.example.core_network.impl.model.NetworkTaskWithId

interface Mappers {
    interface DataToDomainTaskMapper {
        operator fun invoke(databaseTask: DatabaseTask): Task
    }

    interface DomainToDataTaskMapper {
        operator fun invoke(task: Task): DatabaseTask
    }

    interface NetworkToDomainTaskMapper {
        operator fun invoke(networkTask: NetworkTask): Task
    }

    interface DomainToNetworkTaskMappper {
        operator fun invoke(task: Task): NetworkTask
    }

    interface DomainToNetworkWithIdTaskMapper {
        operator fun invoke(task: Task): NetworkTaskWithId
    }
}
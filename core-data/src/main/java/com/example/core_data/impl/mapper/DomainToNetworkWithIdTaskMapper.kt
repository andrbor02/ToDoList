package com.example.core_data.impl.mapper

import com.example.core_model.Task
import com.example.core_network.impl.model.NetworkTask
import com.example.core_network.impl.model.NetworkTaskWithId
import javax.inject.Inject

class DomainToNetworkWithIdTaskMapper @Inject constructor() :
    Mappers.DomainToNetworkWithIdTaskMapper {
    override fun invoke(task: Task): NetworkTaskWithId {
        return NetworkTaskWithId(
            id = task.id.toString(),
            NetworkTask(
                text = task.description,
                priority = task.priority.title,
                deadline = task.deadline,
                completion = task.completion,
                creationDate = task.creationDate,
                changeDate = task.changeDate,
            )
        )
    }
}
package com.example.core_data.impl.mapper

import com.example.core_model.Task
import com.example.core_network.impl.model.NetworkTask
import javax.inject.Inject

class DomainToNetworkTaskMapper @Inject constructor() : Mappers.DomainToNetworkTaskMappper {
    override fun invoke(task: Task): NetworkTask {
        return NetworkTask(
            text = task.description,
            priority = task.priority.title,
            deadline = task.deadline,
            completion = task.completion,
            creationDate = task.creationDate,
            changeDate = task.changeDate,
        )
    }
}
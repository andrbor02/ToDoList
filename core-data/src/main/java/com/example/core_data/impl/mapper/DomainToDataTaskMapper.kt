package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import javax.inject.Inject

internal class DomainToDataTaskMapper @Inject constructor() : Mappers.DomainToDataTaskMapper {
    override operator fun invoke(task: Task): DBTask {
        val taskPriority = when (task.priority) {
            TaskPriority.None -> TaskPriority.None.title
            TaskPriority.Low -> TaskPriority.Low.title
            TaskPriority.High -> TaskPriority.High.title
        }

        return DBTask(
            task.id,
            task.description,
            taskPriority,
            task.deadline,
            task.completion,
            task.creationDate,
            task.changeDate
        )
    }
}
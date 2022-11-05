package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import javax.inject.Inject

class DataToDomainTaskMapper @Inject constructor() : Mappers.DataToDomainTaskMapper {
    override operator fun invoke(dbTask: DBTask): Task {
        val taskPriority = when (dbTask.priority) {
            TaskPriority.None.title -> TaskPriority.None
            TaskPriority.Low.title -> TaskPriority.Low
            TaskPriority.High.title -> TaskPriority.High
            else -> throw IllegalArgumentException("Wrong task priority from DB")
        }

        return Task(
            dbTask.id.toString(),
            dbTask.text,
            taskPriority,
            dbTask.deadline,
            dbTask.completion,
            dbTask.creationDate,
            dbTask.changeDate
        )
    }
}
package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import javax.inject.Inject

class DataToDomainTaskMapper @Inject constructor() : Mappers.DataToDomainTaskMapper {
    override operator fun invoke(databaseTask: DatabaseTask): Task {
        val taskPriority = when (databaseTask.priority) {
            TaskPriority.None.title -> TaskPriority.None
            TaskPriority.Low.title -> TaskPriority.Low
            TaskPriority.High.title -> TaskPriority.High
            else -> throw IllegalArgumentException("Wrong task priority from DB")
        }

        return Task(
            databaseTask.id,
            databaseTask.text,
            taskPriority,
            databaseTask.deadline,
            databaseTask.completion,
            databaseTask.creationDate,
            databaseTask.changeDate
        )
    }
}
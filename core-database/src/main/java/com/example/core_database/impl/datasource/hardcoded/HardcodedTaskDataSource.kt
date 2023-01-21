package com.example.core_database.impl.datasource.hardcoded

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_database.impl.datasource.ReadOnlyTaskDataSource
import com.example.core_database.impl.exception.LocalDataSourceException
import com.example.core_model.TaskPriority
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class HardcodedTaskDataSource @Inject constructor() : ReadOnlyTaskDataSource {

    private val _taskList = MutableStateFlow(emptyList<DatabaseTask>())
    private val taskList = _taskList.asStateFlow()


    override fun getTaskList(): Flow<List<DatabaseTask>> {
        return taskList
    }

    override fun getTaskById(taskId: Long): Flow<Result<DatabaseTask>> {
        val task = taskList.value.find { it.id == taskId }
        return flowOf(
            if (task != null) {
                Result.Success(task)
            } else {
                Result.Error(LocalDataSourceException.TaskByIdNotFoundException(taskId))
            }
        )
    }

    init {
        val initialList = mutableListOf<DatabaseTask>()
        val task1 = DatabaseTask(
            id = 1,
            text = "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
            priority = TaskPriority.High.toString(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { initialList.add(task1) }

        val task2 = DatabaseTask(
            id = 2,
            text = "дела должны быть максимально разнообразны",
            priority = TaskPriority.High.toString(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { initialList.add(task2) }

        val task3 = DatabaseTask(
            id = 3,
            text = "дела должны быть",
            priority = TaskPriority.High.toString(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { initialList.add(task3) }

        _taskList.value = initialList
    }

    override fun toString(): String {
        return "HardcodedTaskDataSource"
    }
}
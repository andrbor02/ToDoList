package com.example.core_database.impl.datasource.room

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_database.impl.datasource.TaskDataSource
import com.example.core_database.impl.exception.LocalDataSourceException
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomTaskDataSource @Inject constructor(
    private val taskDao: TaskDao,
) : TaskDataSource {

    override fun getTaskList(): Flow<List<DatabaseTask>> {
        return taskDao.getTasks()
    }

    override fun getTaskById(taskId: Long): Flow<Result<DatabaseTask>> {
        val task = taskDao.getTaskById(taskId)
        return task.map {
            if (it != null) {
                Result.Success(it)
            } else {
                Result.Error(LocalDataSourceException.TaskByIdNotFoundException(taskId))
            }
        }
    }

    override suspend fun insertTask(task: DatabaseTask) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: DatabaseTask) {
        taskDao.updateTask(task)
    }

    override suspend fun deleteTask(taskId: Long) {
        taskDao.deleteTask(taskId)
    }

}
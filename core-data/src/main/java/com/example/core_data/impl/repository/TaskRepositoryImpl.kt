package com.example.core_data.impl.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.room.TaskDao
import com.example.core_data.impl.mapper.DataToDomainTaskMapper
import com.example.core_data.impl.mapper.DomainToDataTaskMapper
import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import com.example.core_utils.datawrappers.*
import com.example.core_utils.extensions.asResult
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class TaskRepositoryImpl @Inject constructor(
    private val domainToDataTaskMapper: DomainToDataTaskMapper,
    private val dataToDomainTaskMapper: DataToDomainTaskMapper,
    private val taskDao: TaskDao
) : TaskRepository {

    private val dbTaskList: Flow<List<DBTask>> = taskDao.getTasks()

    private val taskList: Flow<List<Task>> = dbTaskList.map { dbList ->
        dbList.map { DBTask ->
            dataToDomainTaskMapper(DBTask)
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(task: Task) {
        if (task.description.isBlank()) {
            return
        }
        val dbTask = domainToDataTaskMapper(task)
        taskDao.insertTask(dbTask)
    }

    @WorkerThread
    override suspend fun update(task: Task) {
        val dbTask = domainToDataTaskMapper(task)
        Log.e("MMMM", "Update in repo $task")
        taskDao.updateTask(dbTask)
    }

    @WorkerThread
    override suspend fun delete(id: Long) {
        taskDao.deleteTask(id)
    }

    override fun getAll(): Flow<List<Task>> {
        return taskList
    }

    override fun getById(id: Long): Flow<Result<Task>> {
        val dbTask: Flow<DBTask> = taskDao.getTaskById(id)
        val task = dbTask.map {
            dataToDomainTaskMapper(it)
        }.asResult()

        return task
    }


}
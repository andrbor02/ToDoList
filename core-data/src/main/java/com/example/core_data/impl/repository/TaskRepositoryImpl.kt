package com.example.core_data.impl.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.core_data.api.repository.TaskRepository
import com.example.core_data.impl.mapper.DataToDomainTaskMapper
import com.example.core_data.impl.mapper.DomainToDataTaskMapper
import com.example.core_data.impl.mapper.DomainToNetworkWithIdTaskMapper
import com.example.core_data.impl.model.DatabaseTask
import com.example.core_database.impl.client.DatabaseClient
import com.example.core_model.Task
import com.example.core_network.impl.client.NetworkClient
import com.example.core_utils.datawrappers.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val domainToDataTaskMapper: DomainToDataTaskMapper,
    private val dataToDomainTaskMapper: DataToDomainTaskMapper,
    private val domainToNetworkWithIdTaskMapper: DomainToNetworkWithIdTaskMapper,
    databaseClient: DatabaseClient,
    networkClient: NetworkClient,
) : TaskRepository {

    private val taskDataSource = databaseClient.getTaskDataSource()
    private val networkDataSource = networkClient.getTaskRemoteDataSource()

    private val dbTaskList: Flow<List<DatabaseTask>> = taskDataSource.getTaskList()

    private val taskList: Flow<List<Task>> = dbTaskList.map { dbList ->
        dbList.map { databaseTask ->
            dataToDomainTaskMapper(databaseTask)
        }
    }

    private var networkList = dbTaskList.map {
        it.map {
            domainToNetworkWithIdTaskMapper(dataToDomainTaskMapper(it))
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(task: Task) {
        if (task.description.isBlank()) {
            return
        }
        val databaseTask = domainToDataTaskMapper(task)
        taskDataSource.insertTask(databaseTask)
    }

    @WorkerThread
    override suspend fun update(task: Task) {
        val databaseTask = domainToDataTaskMapper(task)
        Log.e("MMMM", "Update in repo $task")
        taskDataSource.updateTask(databaseTask)
    }

    @WorkerThread
    override suspend fun delete(id: Long) {
        taskDataSource.deleteTask(id)
    }

    override fun getAll(): Flow<List<Task>> {
        return taskList
    }

    override fun getById(id: Long): Flow<Result<Task>> {
        val databaseTask = taskDataSource.getTaskById(id)
        return databaseTask.map { result ->
            when (result) {
                is Result.Success -> result.map { dataToDomainTaskMapper(it) }
                is Result.Error -> Result.Error(result.exception)
            }
        }
    }

}
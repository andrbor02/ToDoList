package com.example.core_data.impl.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.room.TaskDao
import com.example.core_data.impl.mapper.DataToDomainTaskMapper
import com.example.core_data.impl.mapper.DomainToDataTaskMapper
import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val domainToDataTaskMapper: DomainToDataTaskMapper,
    private val dataToDomainTaskMapper: DataToDomainTaskMapper,
    private val taskDao: TaskDao
) : TaskRepository {

    private val dbTaskList: Flow<List<DBTask>> = taskDao.getTasks()

    val taskList: Flow<List<Task>> = dbTaskList.map { dblist ->
        dblist.map { DBTask ->
            dataToDomainTaskMapper(DBTask)
        }
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(task: Task) {
        if (task.text.isBlank()) {
            return
        }
        val dbTask = domainToDataTaskMapper(task)
        Log.e("MMM", "DBTASK added: $task")
        taskDao.insertTask(dbTask)
    }

    @WorkerThread
    override suspend fun update(task: Task) {
        val dbTask = domainToDataTaskMapper(task)
        taskDao.updateTask(dbTask)
    }

    @WorkerThread
    override suspend fun delete(id: String) {
        val dbId = id.toLong()
        taskDao.deleteTask(dbId)
    }

    override fun getAll(): Flow<List<Task>> {
        return taskList
    }
}
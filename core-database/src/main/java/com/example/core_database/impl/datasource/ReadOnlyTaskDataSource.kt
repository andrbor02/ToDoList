package com.example.core_database.impl.datasource

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow

interface ReadOnlyTaskDataSource {

    fun getTaskList(): Flow<List<DatabaseTask>>

    fun getTaskById(taskId: Long): Flow<Result<DatabaseTask>>
}
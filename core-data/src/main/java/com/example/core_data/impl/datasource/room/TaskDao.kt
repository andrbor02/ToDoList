package com.example.core_data.impl.datasource.room

import androidx.room.*
import com.example.core_data.impl.model.DBTask
import kotlinx.coroutines.flow.Flow

@Dao
internal interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): Flow<List<DBTask>>

    @Query("SELECT * FROM task_table WHERE task_id = :taskId")
    fun getTaskById(taskId: Long): Flow<DBTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: DBTask)

    @Update
    suspend fun updateTask(task: DBTask)

    @Query("DELETE FROM task_table WHERE task_id = :taskId")
    suspend fun deleteTask(taskId: Long)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
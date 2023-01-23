package com.example.core_database.impl.datasource.room

import androidx.room.*
import com.example.core_data.impl.model.DatabaseTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): Flow<List<DatabaseTask>>

    @Query("SELECT * FROM task_table WHERE task_id = :taskId")
    fun getTaskById(taskId: Long): Flow<DatabaseTask?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: DatabaseTask)

    @Update
    suspend fun updateTask(task: DatabaseTask)

    @Query("DELETE FROM task_table WHERE task_id = :taskId")
    suspend fun deleteTask(taskId: Long)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
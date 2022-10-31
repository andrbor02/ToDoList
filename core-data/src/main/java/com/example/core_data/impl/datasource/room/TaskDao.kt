package com.example.core_data.impl.datasource.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): Flow<List<DBTask>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: DBTask)

    @Update
    suspend fun updateTask(task: DBTask)

//    @Delete
//    suspend fun deleteTask(task: DBTask)

    @Query("DELETE FROM task_table WHERE task_id = :taskID")
    suspend fun deleteTask(taskID: Long)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
package com.example.todolistyandex.data.datasource.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core_data.impl.datasource.room.DBTask
import com.example.core_data.impl.datasource.room.RoomDatabaseTaskStorage
import com.example.core_data.impl.datasource.room.TaskDao

@Database(entities = [DBTask::class], version = 1, exportSchema = false)
abstract class RoomDatabaseTaskStorage : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabaseTaskStorage? = null

        fun getDatabase(
            context: Context
        ): RoomDatabaseTaskStorage {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseTaskStorage::class.java,
                    "task_list_database"
                )
                    .build()
                INSTANCE = instance
                Log.e("MMM", "DATABASE CREATED")
                instance
            }
        }
    }
}
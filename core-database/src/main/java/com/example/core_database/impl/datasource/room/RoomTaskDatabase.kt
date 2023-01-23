package com.example.core_data.impl.datasource.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core_data.impl.model.DatabaseTask
import com.example.core_database.impl.datasource.room.TaskDao

@Database(entities = [DatabaseTask::class], version = 1, exportSchema = false)
abstract class RoomTaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: RoomTaskDatabase? = null

        fun getDatabase(
            context: Context
        ): RoomTaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomTaskDatabase::class.java,
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
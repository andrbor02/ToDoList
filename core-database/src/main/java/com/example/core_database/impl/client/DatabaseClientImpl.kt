package com.example.core_database.impl.client

import com.example.core_database.impl.datasource.SettingsDataSource
import com.example.core_database.impl.datasource.TaskDataSource
import com.example.core_database.impl.datasource.room.RoomTaskDataSource
import com.example.core_database.impl.datasource.room.TaskDao
import javax.inject.Inject

class DatabaseClientImpl @Inject constructor(
    private val taskDao: TaskDao,
    private val settingsDataSource: SettingsDataSource
) : DatabaseClient {

    override fun getTaskDataSource(): TaskDataSource {
        return RoomTaskDataSource(taskDao)
    }

    override fun getSettingsDataSource(): SettingsDataSource {
        return settingsDataSource
    }
}
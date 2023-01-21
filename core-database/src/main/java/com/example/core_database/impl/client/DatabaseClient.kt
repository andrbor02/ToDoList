package com.example.core_database.impl.client

import com.example.core_database.impl.datasource.SettingsDataSource
import com.example.core_database.impl.datasource.TaskDataSource

interface DatabaseClient {

    fun getTaskDataSource(): TaskDataSource

    fun getSettingsDataSource(): SettingsDataSource
}
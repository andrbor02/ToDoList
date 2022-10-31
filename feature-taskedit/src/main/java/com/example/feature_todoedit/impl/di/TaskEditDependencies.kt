package com.example.feature_todoedit.impl.di

import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.hardcoded.HardcodedTaskDataSource
import com.example.core_data.impl.datasource.logger.Logger

interface TaskEditDependencies: BaseDependencies {

    fun hardcodedTaskDataSource(): HardcodedTaskDataSource

    fun repository(): TaskRepository

    fun logger(): Logger
}
package com.example.core_data.impl.datasource.logger

import com.example.core_data.api.TaskDataSource
import com.example.core_model.Task

class LoggerTaskDataSource(private val logger: Logger): TaskDataSource {
    override fun saveTaskList(taskList: List<Task>) {
        TODO("Not yet implemented")
    }

    override fun getTasksList(): List<Task> {
        TODO("Not yet implemented")
    }

    fun log() {
        logger.log()
    }
}
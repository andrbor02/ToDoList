package com.example.core_data.api

import com.example.core_data.api.repository.SettingsRepository
import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.BaseApi

interface DataApi: BaseApi {

    fun getTaskRepository(): TaskRepository

    fun getSettingsRepository(): SettingsRepository
}
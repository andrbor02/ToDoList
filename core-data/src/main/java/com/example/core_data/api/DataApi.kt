package com.example.core_data.api

import com.example.core_data.impl.di.BaseApi

interface DataApi: BaseApi {

    fun getTaskRepository(): TaskRepository

    fun getSettingsRepository(): SettingsRepository
}
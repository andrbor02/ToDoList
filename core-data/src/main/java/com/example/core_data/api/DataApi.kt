package com.example.core_data.api

import com.example.core_utils.di.BaseApi

interface DataApi: BaseApi {

    fun getTaskRepository(): TaskRepository
}
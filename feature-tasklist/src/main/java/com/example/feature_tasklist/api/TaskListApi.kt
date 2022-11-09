package com.example.feature_tasklist.api

import com.example.core_utils.di.BaseApi

interface TaskListApi: BaseApi {

    fun starter(): TaskListStarter
}
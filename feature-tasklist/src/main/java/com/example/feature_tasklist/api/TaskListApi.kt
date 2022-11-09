package com.example.feature_tasklist.api

import com.example.feature_tasklist.impl.di.BaseApi

interface TaskListApi: BaseApi {

    fun starter(): TaskListStarter
}
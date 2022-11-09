package com.example.feature_todoedit.api

import com.example.feature_todoedit.impl.di.BaseApi

interface TaskEditApi: BaseApi {

    fun starter(): TaskEditStarter
}
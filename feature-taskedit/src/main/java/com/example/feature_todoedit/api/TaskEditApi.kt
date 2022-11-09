package com.example.feature_todoedit.api

import com.example.core_utils.di.BaseApi

interface TaskEditApi: BaseApi {

    fun starter(): TaskEditStarter
}
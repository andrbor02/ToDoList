package com.example.core_network.api

import com.example.core_network.impl.di.BaseApi

interface NetworkApi : BaseApi {
    fun networkClient()
}
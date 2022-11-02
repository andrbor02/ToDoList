package com.example.core_network.api

import com.example.core_network.impl.di.BaseApi

// TODO make network
interface NetworkApi : BaseApi {
    fun networkClient()
}
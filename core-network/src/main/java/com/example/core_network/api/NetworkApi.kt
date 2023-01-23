package com.example.core_network.api

import com.example.core_model.BaseApi
import com.example.core_network.impl.client.NetworkClient

interface NetworkApi : BaseApi {

    fun getNetworkClient(): NetworkClient
}
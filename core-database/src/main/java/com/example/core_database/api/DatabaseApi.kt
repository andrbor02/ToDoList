package com.example.core_database.api

import com.example.core_database.impl.client.DatabaseClient
import com.example.core_model.BaseApi

interface DatabaseApi : BaseApi {

    fun getDbClient(): DatabaseClient
}
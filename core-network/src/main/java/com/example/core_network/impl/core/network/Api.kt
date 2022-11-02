package com.example.todolistyandex.core.network

import com.example.todolistyandex.core.retrofit.NetworkTask
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://beta.mrdekk.ru/todobackend"

interface Api {
    @GET("$BASE_URL/list")
    suspend fun getList(@Path("task") networkTask: NetworkTask): List<NetworkTask>
}
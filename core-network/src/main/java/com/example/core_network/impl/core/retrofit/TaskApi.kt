package com.example.core_network.impl.core.retrofit

import com.example.core_network.impl.core.model.NetworkTask
import retrofit2.Call
import retrofit2.http.*

interface TaskApi {

    @PATCH("list/{taskId}.json")
    fun addTask(@Path("taskId") id: String, @Body networkTask: NetworkTask): Call<NetworkTask?>?

    @GET("list.json")
    fun getTaskList(): Call<HashMap<String, NetworkTask>>

    @GET("list/{taskId}.json")
    fun getTaskById(@Path("taskId") id: String): Call<NetworkTask>

    @PUT("list/{taskId}.json")
    fun updateTask(@Path("taskId") id: String, @Body networkTask: NetworkTask): Call<NetworkTask?>?

    @DELETE("list/{taskId}.json")
    fun deleteTask(@Path("taskId") id: String): Call<NetworkTask>
}
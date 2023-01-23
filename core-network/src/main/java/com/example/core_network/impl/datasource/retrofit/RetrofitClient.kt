package com.example.core_network.impl.datasource.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://todolist-c0c17-default-rtdb.europe-west1.firebasedatabase.app/"

    private var taskApi: TaskApi? = null

    fun getClient(): TaskApi {
        if (taskApi == null) {
            configure()
        }
        return taskApi!!
    }

    private fun configure() {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        taskApi = retrofit.create(TaskApi::class.java)
    }
}
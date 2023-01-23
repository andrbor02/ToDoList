package com.example.core_network.impl.di

import com.example.core_network.impl.client.NetworkClient
import com.example.core_network.impl.client.NetworkClientImpl
import com.example.core_network.impl.datasource.TaskRemoteDataSource
import com.example.core_network.impl.datasource.retrofit.RetrofitClient
import com.example.core_network.impl.datasource.retrofit.TaskApi
import com.example.core_network.impl.datasource.retrofit.TaskRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideTaskRemoteDataSource(taskRemoteDataSourceImpl: TaskRemoteDataSourceImpl): TaskRemoteDataSource {
        return taskRemoteDataSourceImpl
    }

//    @Singleton
//    @Provides
//    fun provideSynchronizationTaskApi(): TaskApi {
//        return RetrofitTestApp().configureAndGet()
//    }

    @Singleton
    @Provides
    fun provideTaskApi(): TaskApi {
        return RetrofitClient.getClient()
    }

    @Singleton
    @Provides
    fun provideNetworkClient(networkClientImpl: NetworkClientImpl): NetworkClient {
        return networkClientImpl
    }
}
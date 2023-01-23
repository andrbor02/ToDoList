package com.example.core_data.impl.di

import android.content.Context
import com.example.core_data.api.repository.SettingsRepository
import com.example.core_data.api.repository.TaskRepository
import com.example.core_data.impl.mapper.DataToDomainTaskMapper
import com.example.core_data.impl.mapper.DomainToDataTaskMapper
import com.example.core_data.impl.mapper.Mappers
import com.example.core_data.impl.repository.SettingsRepositoryImpl
import com.example.core_data.impl.repository.TaskRepositoryImpl
import com.example.core_database.api.DatabaseApi
import com.example.core_database.api.DatabaseDependencies
import com.example.core_network.api.NetworkApi
import com.example.core_network.api.NetworkDependencies
import com.example.core_network.impl.di.NetworkComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreDataModule {

    @Provides
    fun provideTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository {
        return taskRepositoryImpl
    }

    @Provides
    fun provideSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository {
        return settingsRepositoryImpl
    }

    @Provides
    fun provideDataToDomainTaskMapper(
        dataToDomainTaskMapper: DataToDomainTaskMapper
    ): Mappers.DataToDomainTaskMapper {
        return dataToDomainTaskMapper
    }

    @Provides
    fun provideDomainToDataTaskMapper(
        domainToDataTaskMapper: DomainToDataTaskMapper
    ): Mappers.DomainToDataTaskMapper {
        return domainToDataTaskMapper
    }

}

@Module
class CoreDatabaseProviderModule {

    @Singleton
    @Provides
    fun provideCoreDatabaseDependencies(context: Context): DatabaseDependencies {
        return object : DatabaseDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    fun provideCoreDatabaseApi(dependencies: DatabaseDependencies): DatabaseApi {
        return DatabaseComponent.initAndGet(dependencies)
    }
}

@Module
class CoreNetworkProviderModule {

    @Singleton
    @Provides
    fun provideCoreNetworkDependencies(context: Context): NetworkDependencies {
        return object : NetworkDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    fun provideCoreNetworkApi(dependencies: NetworkDependencies): NetworkApi {
        return NetworkComponent.initAndGet(dependencies)
    }
}
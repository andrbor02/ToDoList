package com.example.core_data.impl.di

import android.content.Context
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.hardcoded.HardcodedTaskDataSource
import com.example.core_data.impl.datasource.room.RoomDatabaseTaskStorage
import com.example.core_data.impl.datasource.room.TaskDao
import com.example.core_data.impl.mapper.DataToDomainTaskMapper
import com.example.core_data.impl.mapper.DomainToDataTaskMapper
import com.example.core_data.impl.mapper.Mappers
import com.example.core_data.impl.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class CoreDataModule {

    @Provides
    fun provideHardcodedTaskDataSource(): HardcodedTaskDataSource {
        return HardcodedTaskDataSource()
    }

    @Provides
    @Singleton
    fun provideDBStorage(context: Context): RoomDatabaseTaskStorage {
        return RoomDatabaseTaskStorage.getDatabase(
            context = context
        )
    }

    @Provides
    fun provideTaskDao(db: RoomDatabaseTaskStorage): TaskDao {
        return db.taskDao()
    }

    @Provides
    fun provideTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository {
        return taskRepositoryImpl
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
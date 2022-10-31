package com.example.core_data.impl.di

import android.content.Context
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.hardcoded.HardcodedTaskDataSource
import com.example.core_data.impl.datasource.room.RoomDatabaseTaskStorage
import com.example.core_data.impl.datasource.room.TaskDao
import com.example.core_data.impl.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class CoreDataModule {

    @Provides
    fun provideHardcodedTaskDataSource(): HardcodedTaskDataSource {
        return HardcodedTaskDataSource()
    }

    @Provides
//  @Singleton
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
    fun provideTaskRepository(
        hardcodedTaskDataSource: HardcodedTaskDataSource,
        taskDao: TaskDao
    ): TaskRepository {
        return TaskRepositoryImpl(
            hardcodedTaskDataSource,
            taskDao
        )
    }
}
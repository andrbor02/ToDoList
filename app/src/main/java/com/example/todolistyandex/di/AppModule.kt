package com.example.todolistyandex.di

import android.content.Context
import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.data.datasource.room.RoomDatabaseTaskStorage
import com.example.todolistyandex.data.datasource.room.TaskDao
import com.example.todolistyandex.data.repository.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [AppBindModule::class])
class AppModule {

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
}

@Module
interface AppBindModule {
    @Binds
    fun bindTaskRepositoryToImpl(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository
}
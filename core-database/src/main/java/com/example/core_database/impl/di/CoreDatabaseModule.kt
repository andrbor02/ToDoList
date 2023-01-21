package com.example.core_data.impl.di

import android.content.Context
import com.example.core_data.impl.datasource.room.RoomTaskDatabase
import com.example.core_data.impl.datasource.sharedprefs.SharedPreferencesSettingsDataSource
import com.example.core_database.impl.client.DatabaseClient
import com.example.core_database.impl.client.DatabaseClientImpl
import com.example.core_database.impl.datasource.SettingsDataSource
import com.example.core_database.impl.datasource.room.TaskDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreDatabaseModule {

    @Provides
    @Singleton
    fun provideDBStorage(context: Context): RoomTaskDatabase {
        return RoomTaskDatabase.getDatabase(
            context = context
        )
    }

    @Provides
    @Singleton
    fun provideTaskDao(roomTaskDatabase: RoomTaskDatabase): TaskDao {
        return roomTaskDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideSettingsDataSource(
        sharedPreferencesSettingsDataSource: SharedPreferencesSettingsDataSource
    ): SettingsDataSource {
        return sharedPreferencesSettingsDataSource
    }

    @Provides
    @Singleton
    fun provideDatabaseClient(databaseClientImpl: DatabaseClientImpl): DatabaseClient {
        return databaseClientImpl
    }

}
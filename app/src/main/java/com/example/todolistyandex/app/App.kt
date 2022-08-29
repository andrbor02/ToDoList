package com.example.todolistyandex.app

import android.app.Application
import com.example.todolistyandex.data.datasource.hardcoded.HardcodedTaskDataSource
import com.example.todolistyandex.data.datasource.room.RoomDatabaseTaskStorage
import com.example.todolistyandex.data.repository.TaskRepositoryImpl
import com.example.todolistyandex.di.AppComponent
import com.example.todolistyandex.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()
    }


    private val dbStorage by lazy {
        RoomDatabaseTaskStorage.getDatabase(
            applicationContext
        )
    }
    private val hardcodedStorage by lazy { HardcodedTaskDataSource() }
    val repository by lazy { TaskRepositoryImpl(hardcodedStorage, dbStorage.taskDao()) }
}
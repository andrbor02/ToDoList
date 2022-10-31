package com.example.todolistyandex.app

import android.app.Application
import com.example.core_data.impl.datasource.hardcoded.HardcodedTaskDataSource
import com.example.core_data.impl.datasource.room.RoomDatabaseTaskStorage
import com.example.core_data.impl.repository.TaskRepositoryImpl
import com.example.todolistyandex.di.AppComponent
import com.example.todolistyandex.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
//    lateinit var dataComponent: CoreDataComponent
//
//    @Inject
//    lateinit var dataDependencies: DataDependencies

    //@Inject
    //lateinit var dataApi: DataApi

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()



        //dataComponent = DaggerCoreDataComponent.factory().create(dataDependencies).inject(applicationContext)
    }


    // TODO: Provide injection into taskEditFragment
    private val dbStorage by lazy {
        RoomDatabaseTaskStorage.getDatabase(
            applicationContext
        )
    }
    private val hardcodedStorage by lazy { HardcodedTaskDataSource() }
    //val repository by lazy { dataApi.getTaskRepository() }
    val repository by lazy { TaskRepositoryImpl(hardcodedStorage, dbStorage.taskDao()) }
}
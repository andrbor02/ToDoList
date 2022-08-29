package com.example.todolistyandex.di

import android.content.Context
import com.example.todolistyandex.todolist.presentation.TasksListFragment
import com.example.todolistyandex.todolist.presentation.stateholders.TasksListViewModelFactory
import dagger.BindsInstance
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectToListFragment(tasksListFragment: TasksListFragment)
    fun injectToListViewModelFactory(tasksListViewModelFactory: TasksListViewModelFactory)
//    fun injectToEditFragment(taskEditFragment: TaskEditFragment)
//
//    appComponent.inject...(this)

    //val dbTaskStorage: RoomDatabaseTaskStorage

    //val hardcodedTaskStorage: HardcodedTaskDataSource

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}
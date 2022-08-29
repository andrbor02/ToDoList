package com.example.todolistyandex.di

import android.content.Context
import com.example.todolistyandex.todoedit.presentation.TaskEditFragment
import com.example.todolistyandex.todolist.presentation.TasksListFragment
import com.example.todolistyandex.todolist.presentation.stateholders.TasksListViewModelFactory
import dagger.BindsInstance
import dagger.Component


@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectToListFragment(tasksListFragment: TasksListFragment)
    fun injectToListViewModelFactory(tasksListViewModelFactory: TasksListViewModelFactory)
    fun injectToEditFragment(taskEditFragment: TaskEditFragment)

    // TODO: make Factory instead of builder
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}
package com.example.feature_tasklist.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_tasklist.api.TaskListApi
import com.example.feature_tasklist.impl.presentation.ui.TasksListFragment
import dagger.Component

@PerFeature
@Component (
    dependencies = [TaskListDependencies::class],
    modules = [TaskListModule::class]
)
interface TaskListComponent: TaskListApi {
    fun inject(fragment: TasksListFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: TaskListDependencies): TaskListComponent
    }

    companion object {
        fun initAndGet(dependencies: TaskListDependencies): TaskListComponent {
            return DaggerTaskListComponent.factory().create(dependencies)
        }
    }
}
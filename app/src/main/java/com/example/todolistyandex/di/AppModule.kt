package com.example.todolistyandex.di

import android.content.Context
import com.example.core_data.api.DataApi
import com.example.core_data.api.DataDependencies
import com.example.core_data.api.repository.SettingsRepository
import com.example.core_data.api.repository.TaskRepository
import com.example.core_data.impl.di.CoreDataComponent
import com.example.feature_tasklist.api.TaskListApi
import com.example.feature_tasklist.impl.di.TaskListComponentHolder
import com.example.feature_tasklist.impl.di.TaskListDependencies
import com.example.feature_tasklist.impl.presentation.navigation.TasksListNavigation
import com.example.feature_todoedit.api.TaskEditApi
import com.example.feature_todoedit.impl.di.TaskEditComponentHolder
import com.example.feature_todoedit.impl.di.TaskEditDependencies
import com.example.todolistyandex.routing.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

}

@Module
class FeatureTaskListProviderModule {

    @Provides
    fun provideTaskListDependencies(
        coreDataApi: DataApi,
        navigation: Navigator
    ): TaskListDependencies {
        return object : TaskListDependencies {
            override fun taskRepository(): TaskRepository {
                return coreDataApi.getTaskRepository()
            }

            override fun settingsRepository(): SettingsRepository {
                return coreDataApi.getSettingsRepository()
            }

            override fun navigation(): TasksListNavigation {
                return navigation
            }
        }
    }

    @Provides
    fun provideTaskListApi(dependencies: TaskListDependencies): TaskListApi {
        TaskListComponentHolder.init(dependencies)
        return TaskListComponentHolder.get()
    }

}

@Module
class FeatureTaskEditProviderModule {
    @Singleton
    @Provides
    fun provideTaskEditDependencies(
        coreDataApi: DataApi
    ): TaskEditDependencies {
        return object : TaskEditDependencies {
            override fun repository(): TaskRepository {
                return coreDataApi.getTaskRepository()
            }
        }
    }

    @Provides
    fun provideTaskEditApi(dependencies: TaskEditDependencies): TaskEditApi {
        TaskEditComponentHolder.init(dependencies)
        return TaskEditComponentHolder.get()
    }

}

@Module
class CoreDataProviderModule {

    @Singleton
    @Provides
    fun provideCoreDataDependencies(context: Context): DataDependencies {
        return object : DataDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    fun provideCoreDataApi(dependencies: DataDependencies): DataApi {
        return CoreDataComponent.initAndGet(dependencies)
    }

}
package com.example.feature_tasklist.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_tasklist.api.TaskListStarter
import com.example.feature_tasklist.impl.starter.TaskListStarterImpl
import dagger.Module
import dagger.Provides

@Module
class TaskListModule {

    @PerFeature
    @Provides
    fun provideStarter(): TaskListStarter {
        return TaskListStarterImpl()
    }
}

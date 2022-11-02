package com.example.feature_todoedit.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_todoedit.api.TaskEditStarter
import com.example.feature_todoedit.impl.starter.TaskEditStarterImpl
import dagger.Module
import dagger.Provides

@Module
class TaskEditModule {

    @PerFeature
    @Provides
    fun provideStarter(): TaskEditStarter {
        return TaskEditStarterImpl()
    }
}

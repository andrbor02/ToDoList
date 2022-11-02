package com.example.feature_todoedit.impl.di

import com.example.core_data.api.TaskRepository

interface TaskEditDependencies: BaseDependencies {
    fun repository(): TaskRepository
}
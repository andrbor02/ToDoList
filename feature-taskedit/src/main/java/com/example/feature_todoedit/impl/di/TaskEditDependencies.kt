package com.example.feature_todoedit.impl.di

import com.example.core_data.api.repository.TaskRepository

interface TaskEditDependencies: BaseDependencies {
    fun repository(): TaskRepository
}
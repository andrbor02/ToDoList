package com.example.feature_todoedit.impl.di

import com.example.core_data.api.TaskRepository
import com.example.core_utils.di.BaseDependencies

interface TaskEditDependencies: BaseDependencies {
    fun repository(): TaskRepository
}
package com.example.feature_tasklist.impl.di

import com.example.core_data.api.repository.SettingsRepository
import com.example.core_data.api.repository.TaskRepository
import com.example.feature_tasklist.impl.presentation.navigation.TasksListNavigation

interface TaskListDependencies: BaseDependencies {

    fun taskRepository(): TaskRepository

    fun settingsRepository(): SettingsRepository

    fun navigation(): TasksListNavigation
}
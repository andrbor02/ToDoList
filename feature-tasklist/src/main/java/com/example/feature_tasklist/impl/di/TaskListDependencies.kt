package com.example.feature_tasklist.impl.di

import com.example.core_data.api.TaskRepository
import com.example.feature_tasklist.impl.presentation.navigation.TasksListNavigation

interface TaskListDependencies: BaseDependencies {

    fun repository(): TaskRepository

    fun navigation(): TasksListNavigation
}
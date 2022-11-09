package com.example.feature_tasklist.impl.di

import com.example.core_utils.di.ComponentHolder
import com.example.feature_tasklist.api.TaskListApi


object TaskListComponentHolder : ComponentHolder<TaskListApi, TaskListDependencies> {

    private var component: TaskListComponent? = null

    override fun init(dependencies: TaskListDependencies) {
        if (component == null) {
            synchronized(TaskListComponentHolder::class.java) {
                if (component == null) {
                    component = TaskListComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): TaskListApi = getComponent()

    internal fun getComponent(): TaskListComponent {
        checkNotNull(component) { "TaskListComponent is not initialized" }
        return component!!
    }

    override fun reset() {
        component = null
    }
}
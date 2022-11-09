package com.example.feature_todoedit.impl.di

import com.example.core_utils.di.ComponentHolder
import com.example.feature_todoedit.api.TaskEditApi

object TaskEditComponentHolder : ComponentHolder<TaskEditApi, TaskEditDependencies> {

    private var component: TaskEditComponent? = null

    override fun init(dependencies: TaskEditDependencies) {
        if (component == null) {
            synchronized(TaskEditComponentHolder::class.java) {
                if (component == null) {
                    component = TaskEditComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): TaskEditApi = getComponent()

    internal fun getComponent(): TaskEditComponent {
        checkNotNull(component) { "TaskEditComponent is not initialized" }
        return component!!
    }

    override fun reset() {
        component = null
    }
}
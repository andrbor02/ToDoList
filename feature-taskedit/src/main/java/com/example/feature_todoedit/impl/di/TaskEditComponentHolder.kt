package com.example.feature_todoedit.impl.di

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
//        return object : TaskEditComponent {
//            override fun inject(fragment: TaskEditFragment) {
//                TODO("Not yet implemented")
//            }
//
//            override fun starter(): TaskEditStarter {
//                Log.e("MMM", "MAMOHT")
//                return TaskEditStarterImpl()
//            }
//        }
    }

    override fun reset() {
        component = null
    }
}
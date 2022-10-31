package com.example.feature_tasklist.impl.di

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
//        return object : TaskListComponent {
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
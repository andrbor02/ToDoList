package com.example.core_data.impl.di

import com.example.core_data.api.DataApi
import com.example.core_data.api.DataDependencies

object CoreDataComponentHolder : ComponentHolder<DataApi, DataDependencies> {

    private var component: CoreDataComponent? = null

    override fun init(dependencies: DataDependencies) {
        if (component == null) {
            synchronized(CoreDataComponentHolder::class.java) {
                if (component == null) {
                    component = CoreDataComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): DataApi = getComponent()

    internal fun getComponent(): CoreDataComponent {
        checkNotNull(component) { "TaskEditComponent is not initialized" }
        return component!!
    }
}
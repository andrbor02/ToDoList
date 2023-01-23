package com.example.core_data.impl.di

import com.example.core_database.api.DatabaseApi
import com.example.core_database.api.DatabaseDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DatabaseDependencies::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: DatabaseDependencies): DatabaseComponent
    }

    companion object {

        private var component: DatabaseComponent? = null

        fun initAndGet(dependencies: DatabaseDependencies): DatabaseComponent {
            if (component == null) {
                synchronized(DatabaseComponent::class.java) {
                    if (component == null) {
                        component = DaggerDatabaseComponent.factory().create(dependencies)
                    }
                }
            }
            return component!!
        }
    }
}
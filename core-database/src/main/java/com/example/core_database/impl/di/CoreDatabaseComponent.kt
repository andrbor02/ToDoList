package com.example.core_data.impl.di

import com.example.core_database.api.DatabaseApi
import com.example.core_database.api.DatabaseDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DatabaseDependencies::class],
    modules = [CoreDatabaseModule::class]
)
interface CoreDatabaseComponent : DatabaseApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: DatabaseDependencies): CoreDatabaseComponent
    }

    companion object {

        private var component: CoreDatabaseComponent? = null

        fun initAndGet(dependencies: DatabaseDependencies): CoreDatabaseComponent {
            if (component == null) {
                synchronized(CoreDatabaseComponent::class.java) {
                    if (component == null) {
                        component = DaggerCoreDatabaseComponent.factory().create(dependencies)
                    }
                }
            }
            return component!!
        }
    }
}
package com.example.core_data.impl.di

import com.example.core_data.api.DataApi
import com.example.core_data.api.DataDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (
    dependencies = [DataDependencies::class],
    modules = [CoreDataModule::class]
        )
interface CoreDataComponent: DataApi {
    //fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(dependencies: DataDependencies): CoreDataComponent
    }

    companion object {
        fun initAndGet(dependencies: DataDependencies): CoreDataComponent {
            return DaggerCoreDataComponent.factory().create(dependencies)
        }
    }
}
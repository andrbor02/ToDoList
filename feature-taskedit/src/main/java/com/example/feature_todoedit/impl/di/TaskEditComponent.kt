package com.example.feature_todoedit.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_todoedit.api.TaskEditApi
import com.example.feature_todoedit.impl.presentation.ui.TaskEditFragment
import dagger.Component

@PerFeature
@Component (
    dependencies = [TaskEditDependencies::class],
    modules = [TaskEditModule::class]
)
interface TaskEditComponent: TaskEditApi {
    fun inject(fragment: TaskEditFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: TaskEditDependencies): TaskEditComponent
    }

    companion object {
        fun initAndGet(dependencies: TaskEditDependencies): TaskEditComponent {
            return DaggerTaskEditComponent.factory().create(dependencies)
        }
    }


//    @Component(dependencies = [DataApi::class])
//    @PerFeature
//    interface TaskEditDependenciesComponent: TaskEditDependencies { }

}
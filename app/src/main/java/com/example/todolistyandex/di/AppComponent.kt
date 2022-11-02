package com.example.todolistyandex.di

import android.content.Context
import com.example.core_data.impl.di.CoreDataModule
import com.example.todolistyandex.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, CoreDataModule::class])
@Singleton
interface AppComponent {

    fun injectToMainActivity(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}
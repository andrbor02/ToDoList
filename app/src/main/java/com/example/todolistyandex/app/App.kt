package com.example.todolistyandex.app

import android.app.Application
import com.example.todolistyandex.di.AppComponent
import com.example.todolistyandex.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        re
        appComponent = DaggerAppComponent.factory().create(this)
    }

}
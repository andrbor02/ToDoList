package com.example.core_data.api

import android.content.Context
import com.example.core_data.impl.di.BaseDependencies

interface DataDependencies: BaseDependencies {

    fun context(): Context
}
package com.example.core_data.api

import android.content.Context
import com.example.core_model.BaseDependencies

interface DataDependencies: BaseDependencies {

    fun context(): Context
}
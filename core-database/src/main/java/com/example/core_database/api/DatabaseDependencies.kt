package com.example.core_database.api

import android.content.Context
import com.example.core_model.BaseDependencies

interface DatabaseDependencies : BaseDependencies {

    fun context(): Context

}
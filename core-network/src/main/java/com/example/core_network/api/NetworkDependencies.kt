package com.example.core_network.api

import android.content.Context
import com.example.core_network.impl.di.BaseDependencies

interface NetworkDependencies : BaseDependencies {

    fun context(): Context
}
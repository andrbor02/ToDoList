package com.example.core_data.impl.di

import com.example.core_utils.di.BaseApi
import com.example.core_utils.di.BaseDependencies

internal interface ComponentHolder<C : BaseApi, D : BaseDependencies> {
    fun init(dependencies: D)

    fun get(): C
}
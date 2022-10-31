package com.example.core_data.impl.di

interface ComponentHolder<C: BaseApi, D: BaseDependencies> {
    fun init(dependencies: D)

    fun get(): C
}

interface BaseDependencies

interface BaseApi
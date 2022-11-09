package com.example.core_utils.di

interface ComponentHolder<C: BaseApi, D: BaseDependencies> {

    fun init(dependencies: D)

    fun get(): C

    fun reset()
}

interface BaseDependencies

interface BaseApi
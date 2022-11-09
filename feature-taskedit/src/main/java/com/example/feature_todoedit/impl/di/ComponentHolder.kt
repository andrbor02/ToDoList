package com.example.feature_todoedit.impl.di

interface ComponentHolder<C: BaseApi, D: BaseDependencies> {

    fun init(dependencies: D)

    fun get(): C

    fun reset()
}

interface BaseDependencies

interface BaseApi
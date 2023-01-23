package com.example.core_database.impl.datasource

import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {

    fun setShowCompletedFlag(isShown: Boolean)

    fun getShowCompletedFlag(): Flow<Boolean>
}
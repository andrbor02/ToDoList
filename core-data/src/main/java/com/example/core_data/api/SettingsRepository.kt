package com.example.core_data.api

import kotlinx.coroutines.flow.Flow


interface SettingsRepository {

    fun setShowCompletedFlag(isShown: Boolean)

    fun getShowCompletedFlag(): Flow<Boolean>
}
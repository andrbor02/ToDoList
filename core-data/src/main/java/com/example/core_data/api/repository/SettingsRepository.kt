package com.example.core_data.api.repository

import kotlinx.coroutines.flow.Flow


interface SettingsRepository {

    fun setShowCompletedFlag(isShown: Boolean)

    fun getShowCompletedFlag(): Flow<Boolean>
}
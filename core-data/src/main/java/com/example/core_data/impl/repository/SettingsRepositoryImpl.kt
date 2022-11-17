package com.example.core_data.impl.repository

import com.example.core_data.api.SettingsRepository
import com.example.core_data.impl.datasource.sharedprefs.SharedPreferencesSettingsDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val settingsDataSource: SharedPreferencesSettingsDataSource
) : SettingsRepository {
    override fun setShowCompletedFlag(isShown: Boolean) {
        settingsDataSource.setShowCompletedFlag(isShown)
    }

    override fun getShowCompletedFlag(): Flow<Boolean> {
        return settingsDataSource.getShowCompletedFlag()
    }
}
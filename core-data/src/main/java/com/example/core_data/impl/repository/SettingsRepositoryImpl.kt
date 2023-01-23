package com.example.core_data.impl.repository

import com.example.core_data.api.repository.SettingsRepository
import com.example.core_database.impl.client.DatabaseClient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    databaseClient: DatabaseClient
) : SettingsRepository {

    private val settingsDataSource = databaseClient.getSettingsDataSource()

    override fun setShowCompletedFlag(isShown: Boolean) {
        settingsDataSource.setShowCompletedFlag(isShown)
    }

    override fun getShowCompletedFlag(): Flow<Boolean> {
        return settingsDataSource.getShowCompletedFlag()
    }
}
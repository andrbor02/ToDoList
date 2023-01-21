package com.example.feature_tasklist.impl.domain.usecase

import com.example.core_data.api.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class ChangeCompletedVisibilityUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend fun changeAndGet(): Flow<Boolean> {
        getCurrent().collectLatest { isShown ->
            val reversedIsShown = isShown.not()
            settingsRepository.setShowCompletedFlag(reversedIsShown)
        }
        return getCurrent()
    }

    suspend fun getCurrent(): Flow<Boolean> = settingsRepository.getShowCompletedFlag()
}
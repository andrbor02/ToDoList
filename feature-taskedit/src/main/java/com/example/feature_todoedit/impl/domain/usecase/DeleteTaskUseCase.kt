package com.example.feature_todoedit.impl.domain.usecase

import com.example.core_data.api.repository.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.delete(id)
    }
}
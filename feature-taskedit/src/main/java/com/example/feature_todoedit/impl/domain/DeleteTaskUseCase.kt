package com.example.feature_todoedit.impl.domain

import com.example.core_data.api.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: String) {
        repository.delete(id)
    }
}
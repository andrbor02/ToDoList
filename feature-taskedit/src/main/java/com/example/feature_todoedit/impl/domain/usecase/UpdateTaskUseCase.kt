package com.example.feature_todoedit.impl.domain.usecase

import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.Task
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.update(task)
    }
}
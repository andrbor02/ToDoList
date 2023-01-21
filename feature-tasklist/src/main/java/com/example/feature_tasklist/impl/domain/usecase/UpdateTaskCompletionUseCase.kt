package com.example.feature_tasklist.impl.domain.usecase

import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.Task
import javax.inject.Inject

class UpdateTaskCompletionUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        return taskRepository.update(task)
    }
}

package com.example.feature_todoedit.impl.domain.usecase

import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.Task
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        taskRepository.insert(task = task)
    }
}
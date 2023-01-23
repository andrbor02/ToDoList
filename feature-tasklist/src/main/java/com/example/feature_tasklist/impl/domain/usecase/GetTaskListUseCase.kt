package com.example.feature_tasklist.impl.domain.usecase

import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return taskRepository.getAll()
    }
}
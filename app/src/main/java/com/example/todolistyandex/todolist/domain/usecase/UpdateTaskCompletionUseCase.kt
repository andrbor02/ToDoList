package com.example.todolistyandex.todolist.domain.usecase

import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.app.domain.model.Task
import javax.inject.Inject

class UpdateTaskCompletionUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        return taskRepository.update(task)
    }
}

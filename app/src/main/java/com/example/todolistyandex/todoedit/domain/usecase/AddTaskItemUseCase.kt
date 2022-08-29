package com.example.todolistyandex.todoedit.domain.usecase

import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.app.domain.model.Task
import javax.inject.Inject

class AddTaskItemUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        taskRepository.insert(task = task)
    }
}
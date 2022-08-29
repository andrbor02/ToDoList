package com.example.todolistyandex.todolist.domain.usecase

import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.app.domain.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return taskRepository.get()
    }
}
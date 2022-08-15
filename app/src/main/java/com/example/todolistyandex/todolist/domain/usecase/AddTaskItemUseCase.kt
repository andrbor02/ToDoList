package com.example.todolistyandex.todolist.domain.usecase

import com.example.todolistyandex.todolist.domain.repository.TaskRepository
import com.example.todolistyandex.todolist.presentation.model.Task

class AddTaskItemUseCase(private val taskRepository: TaskRepository) {
    fun execute(task: Task) {
        taskRepository.add(task = task)
    }
}
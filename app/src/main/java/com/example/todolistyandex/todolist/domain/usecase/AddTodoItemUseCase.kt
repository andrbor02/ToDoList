package com.example.todolistyandex.todolist.domain.usecase

import com.example.todolistyandex.todolist.domain.repository.TodoItemsRepository
import com.example.todolistyandex.todolist.presentation.model.TodoItem

class AddTodoItemUseCase(private val todoItemsRepository: TodoItemsRepository) {
    fun execute(todoItem: TodoItem) {
        todoItemsRepository.add(todoItem = todoItem)
    }
}
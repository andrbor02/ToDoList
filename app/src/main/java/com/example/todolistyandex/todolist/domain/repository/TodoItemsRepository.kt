package com.example.todolistyandex.todolist.domain.repository

import com.example.todolistyandex.todolist.presentation.model.TodoItem

interface TodoItemsRepository {

    fun add(todoItem: TodoItem)

    fun delete(id: String)
}
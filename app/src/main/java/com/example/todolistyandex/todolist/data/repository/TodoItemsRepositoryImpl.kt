package com.example.todolistyandex.todolist.data.repository

import com.example.todolistyandex.todolist.presentation.model.TaskPriority
import com.example.todolistyandex.todolist.presentation.model.TodoItem

class TodoItemsRepositoryImpl {

    fun addTodoItem(todoItem: TodoItem) {

    }

    fun getTodoItemsList() : ArrayList<TodoItem> {

        val todoItemsList = ArrayList<TodoItem>()

        val todoItem1 = TodoItem(
            id = "44",
            text = "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { todoItemsList.add(todoItem1) }

        val todoItem2 = TodoItem(
            id = "44",
            text = "дела должны быть максимально разнообразны",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { todoItemsList.add(todoItem2) }

        val todoItem3 = TodoItem(
            id = "44",
            text = "дела должны быть",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { todoItemsList.add(todoItem3) }

        return todoItemsList
    }
}
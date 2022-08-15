package com.example.todolistyandex.todolist.data.storage

import com.example.todolistyandex.todolist.presentation.model.TodoItem

interface TodoItemStrorage {

    fun saveTodoList(todoList: ArrayList<TodoItem>)

    fun getTodoList(): ArrayList<TodoItem>
}
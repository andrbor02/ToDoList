package com.example.todolistyandex.todolist.presentation.model

sealed class TaskPriority {

    class None() : TaskPriority()

    class Low() : TaskPriority()

    class High() : TaskPriority()
}

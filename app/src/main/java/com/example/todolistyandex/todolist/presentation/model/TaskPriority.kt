package com.example.todolistyandex.todolist.presentation.model

sealed class TaskPriority {

    object None : TaskPriority()

    object Low : TaskPriority()

    object High : TaskPriority()
}

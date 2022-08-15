package com.example.todolistyandex.todolist.presentation.model

import java.io.Serializable

data class TodoItem(
    val id: String,
    val text: String,
    val priority: TaskPriority,
    val deadline: String = "",
    val completion: Boolean,
    val creationDate: String,
    val changeDate: String = ""
) : Serializable
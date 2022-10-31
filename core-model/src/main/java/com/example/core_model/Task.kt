package com.example.core_model

import java.io.Serializable

data class Task(
    val id: String,
    val text: String,
    val priority: TaskPriority,
    val deadline: String = "",
    var completion: Boolean,
    val creationDate: String,
    val changeDate: String = ""
) : Serializable
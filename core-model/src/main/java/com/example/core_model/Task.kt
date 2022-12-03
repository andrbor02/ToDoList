package com.example.core_model

import java.io.Serializable

data class Task(
    val id: Long,
    val description: String,
    val priority: TaskPriority,
    val deadline: String = "",
    var completion: Boolean,
    val creationDate: String,
    val changeDate: String = ""
) : Serializable
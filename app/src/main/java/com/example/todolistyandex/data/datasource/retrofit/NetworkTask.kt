package com.example.todolistyandex.data.datasource.retrofit

data class NetworkTask(
    val id: Long,
    val text: String,
    val priority: String, //TaskPriority
    val deadline: String = "",
    val completion: Boolean,
    val creationDate: String,
    val changeDate: String = ""
)

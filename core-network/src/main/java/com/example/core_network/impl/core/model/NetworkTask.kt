package com.example.core_network.impl.core.model

data class NetworkTask(
//    val id: Long,
    val text: String,
    val priority: String, //TaskPriority
    val deadline: String = "",
    val completion: Boolean,
    val creationDate: String,
    val changeDate: String = ""
)

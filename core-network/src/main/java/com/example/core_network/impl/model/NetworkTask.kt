package com.example.core_network.impl.model

import com.google.gson.annotations.SerializedName

data class NetworkTask(
//    val id: Long,

    @SerializedName("text")
    val text: String,
    @SerializedName("priority")
    val priority: String, //TaskPriority
    @SerializedName("deadline")
    val deadline: String = "",
    @SerializedName("completion")
    val completion: Boolean,
    @SerializedName("creationDate")
    val creationDate: String,
    @SerializedName("changeDate")
    val changeDate: String = ""
)
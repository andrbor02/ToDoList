package com.example.core_network.impl.core.model

import com.google.gson.annotations.SerializedName

data class TestTask(
    @SerializedName("text")
    val text: String,

    @SerializedName("priority")
    val priority: String
)

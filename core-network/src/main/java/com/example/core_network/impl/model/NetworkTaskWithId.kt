package com.example.core_network.impl.model

data class NetworkTaskWithId(val id: String, val task: NetworkTask) {
    fun toPair(): Pair<String, NetworkTask> {
        return (id to task)
    }
}
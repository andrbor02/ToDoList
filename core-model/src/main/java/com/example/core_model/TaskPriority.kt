package com.example.core_model

sealed class TaskPriority {

    object None : TaskPriority() {
        val name: String = this.javaClass.simpleName

        const val title = "Нет"
    }

    object Low : TaskPriority() {
        val name: String = this.javaClass.simpleName

        const val title = "Низкий"
    }

    object High : TaskPriority() {
        val name: String = this.javaClass.simpleName

        const val title = "Высокий"
    }

//    TODO get titles from resources to support multilingual
}

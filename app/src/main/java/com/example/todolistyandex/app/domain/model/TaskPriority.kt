package com.example.todolistyandex.app.domain.model

sealed class TaskPriority {

    object None : TaskPriority() {
        val name: String = this.javaClass.simpleName

        val title = "Нет"
    }

    object Low : TaskPriority() {
        val name: String = this.javaClass.simpleName

        val title = "Низкий"
    }

    object High : TaskPriority() {
        val name: String = this.javaClass.simpleName

        val title = "Высокий"
    }

//    TODO get titles from resources to support multilingual
}

package com.example.core_model

sealed class TaskPriority {
    abstract val title: String

    object None : TaskPriority() {
        val name: String = this.javaClass.simpleName

        override val title = "Нет"
    }

    object Low : TaskPriority() {
        val name: String = this.javaClass.simpleName

        override val title = "Низкий"
    }

    object High : TaskPriority() {
        val name: String = this.javaClass.simpleName

        override fun toString(): String {
            return "Высокий"
        }

        override val title = "Высокий"
    }

    override fun toString(): String {
        return this.title
    }
//    TODO get titles from resources to support multilingual
}

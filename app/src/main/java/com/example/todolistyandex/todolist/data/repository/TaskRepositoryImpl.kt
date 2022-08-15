package com.example.todolistyandex.todolist.data.repository

import com.example.todolistyandex.todolist.presentation.model.TaskPriority
import com.example.todolistyandex.todolist.presentation.model.Task

class TaskRepositoryImpl {

    fun addTask(task: Task) {

    }

    fun getTasksList() : ArrayList<Task> {

        val tasksList = ArrayList<Task>()

        val task1 = Task(
            id = "44",
            text = "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task1) }

        val task2 = Task(
            id = "44",
            text = "дела должны быть максимально разнообразны",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task2) }

        val task3 = Task(
            id = "44",
            text = "дела должны быть",
            priority = TaskPriority.High(),
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task3) }

        return tasksList
    }
}
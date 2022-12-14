package com.example.core_data.impl.datasource.hardcoded

import com.example.core_data.api.TaskDataSource
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import javax.inject.Inject

//TODO refactor this class
class HardcodedTaskDataSource @Inject constructor () : TaskDataSource {

    //    private val _taskList = Flow<List<Task>>()
//    val taskList: LiveData<List<Task>> = _taskList
//
    override fun saveTaskList(taskList: List<Task>) {
        //_taskList.value = taskList
    }
//
override fun getTasksList(): List<Task> {
//        return taskList.value.orEmpty()
    return emptyList()
}

    init {
        val tasksList = ArrayList<Task>()

        val task1 = Task(
            id = 44,
            description = "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
            priority = TaskPriority.High,
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task1) }

        val task2 = Task(
            id = 44,
            description = "дела должны быть максимально разнообразны",
            priority = TaskPriority.High,
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task2) }

        val task3 = Task(
            id = 44,
            description = "дела должны быть",
            priority = TaskPriority.High,
            deadline = "13.05.2020",
            false,
            "34.99.22",
            "12.34.5678"
        )
        repeat(5) { tasksList.add(task3) }

//        _taskList.value = tasksList
    }

    override fun toString(): String {
        return "HardcodedTaskDataSource"
    }
}
package com.example.feature_tasklist.impl.domain.utils

import com.example.core_model.Task

object TaskCompletionListFilter {

    fun filterCompletedHide(taskList: List<Task>): List<Task> {
        val filteredList = taskList.filter { task ->
            task.completion == false
        }
        return defaultSort(filteredList)
    }

    fun filterCompletedShown(taskList: List<Task>): List<Task> {
        return defaultSort(taskList)
    }


    private fun defaultSort(taskList: List<Task>): List<Task> {
        return taskList.sortedWith(compareBy({ it.completion }, { it.changeDate }))
    }
}
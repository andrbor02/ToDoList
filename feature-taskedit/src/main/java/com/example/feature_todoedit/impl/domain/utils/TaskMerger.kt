package com.example.feature_todoedit.impl.domain.utils

import android.icu.util.Calendar
import com.example.core_model.Task

class TaskMerger(
    private val extractedTask: Task,
    private val currentTask: Task
) {

    fun merge(): Task {
        val editedTask = extractedTask.copy(
            id = currentTask.id,
            completion = currentTask.completion,
            creationDate = currentTask.creationDate,
            changeDate = Calendar.getInstance().time.toString()
        )
        return editedTask
    }
}
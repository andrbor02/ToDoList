package com.example.feature_todoedit.impl.domain.utils

import android.icu.util.Calendar
import com.example.core_model.Task
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding

class TaskExtractor(
    private val binding: FragmentTaskEditBinding
) {

    fun extract(): Task {
        val taskName = binding.taskDescription.text.toString()
        val taskPriority = PriorityChecker(binding)
        val taskDeadline = binding.taskDeadline.text.toString()

        return Task(
            0,
            taskName,
            taskPriority,
            taskDeadline,
            false,
            Calendar.getInstance().time.toString(),
            Calendar.getInstance().time.toString()
        )
    }
}


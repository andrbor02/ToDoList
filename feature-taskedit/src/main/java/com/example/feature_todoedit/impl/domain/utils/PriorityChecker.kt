package com.example.feature_todoedit.impl.domain.utils

import com.example.core_model.TaskPriority
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding

object PriorityChecker {
    operator fun invoke(binding: FragmentTaskEditBinding): TaskPriority {
        return when (binding.taskPriority.text.toString()) {
            TaskPriority.None.title -> TaskPriority.None
            TaskPriority.Low.title -> TaskPriority.Low
            TaskPriority.High.title -> TaskPriority.High
            else -> throw IllegalArgumentException("No such priority state!")
        }
    }
}
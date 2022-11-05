package com.example.todolistyandex

import com.example.core_model.Task
import com.example.core_model.TaskPriority


class TaskListProducer() {

    fun getEmptyTaskList(): List<Task> {
        val emptyList = emptyList<Task>()
        return emptyList
    }

    fun getSmallTaskList(): List<Task> {
        val tp = TaskProducer()

        val smallList = listOf(
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
        )
        return smallList
    }

    fun getHugeTaskList(): List<Task> {
        val tp = TaskProducer()

        val hugeList = listOf(
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask, tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask, tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask,
            tp.minimalInitializedTask,
            tp.taskInitializedWithoutDeadline,
            tp.taskInitializedWithoutChangeDate,
            tp.fullyInitializedTask
        )
        return hugeList
    }


    private class TaskProducer() {

        private val defaultId = 0L
        private val defaultText = "Default task"
        private val defaultPriority = TaskPriority.None
        private val defaultCreationDate = "Default creation date"
        private val defaultCompletion = false

        // params with default value in Task class
        private val defaultDeadline = "Default deadline"
        private val defaultChangeDate = "Default change date"


        val minimalInitializedTask = Task(
            id = defaultId,
            text = defaultText,
            priority = defaultPriority,
            creationDate = defaultCreationDate,
            completion = defaultCompletion
            //deadline =
            //changeDate =
        )

        val taskInitializedWithoutDeadline = Task(
            id = defaultId,
            text = defaultText,
            priority = defaultPriority,
            creationDate = defaultCreationDate,
            completion = defaultCompletion,
            changeDate = defaultChangeDate
            //deadline =
        )

        val taskInitializedWithoutChangeDate = Task(
            id = defaultId,
            text = defaultText,
            priority = defaultPriority,
            creationDate = defaultCreationDate,
            completion = defaultCompletion,
            deadline = defaultDeadline
            //changeDate =
        )

        val fullyInitializedTask = Task(
            id = defaultId,
            text = defaultText,
            priority = defaultPriority,
            creationDate = defaultCreationDate,
            completion = defaultCompletion,
            deadline = defaultDeadline,
            changeDate = defaultChangeDate
        )
    }
}
package com.example.todolistyandex.data.datasource.sharedprefs

import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.data.datasource.TaskDataSource

class SharedPrefsTaskDataSource() : TaskDataSource {

    override fun saveTaskList(taskList: List<Task>) {
        TODO("Not yet implemented")
    }

    override fun getTasksList(): ArrayList<Task> {
        TODO("Not yet implemented")
    }


}
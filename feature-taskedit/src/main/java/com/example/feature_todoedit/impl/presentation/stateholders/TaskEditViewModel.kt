package com.example.feature_todoedit.impl.presentation.stateholders

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.logger.LoggerTaskDataSource
import com.example.core_model.Task
import com.example.feature_todoedit.impl.domain.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.DeleteTaskUseCase
import kotlinx.coroutines.launch

class TaskEditViewModel(
//    private val getTaskListUseCase: GetTaskListUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val loggerTaskDataSource: LoggerTaskDataSource,
    private val repository: TaskRepository
) : ViewModel() {

    fun insert(task: Task) = viewModelScope.launch {
        Log.e("MMMM", "Task in VM: $task")
        addTaskUseCase(task)
    }

    suspend fun delete(task: Task) {
        deleteTaskUseCase("1")
    }

//    fun addTask(task: Task) {
//        addTaskUseCase.execute(task)
//    }

    fun getHard() {
        //Log.e("MMMM", hardcodedTaskDataSource.toString())
        Log.e("MMMM", repository.toString())
        loggerTaskDataSource.log()

    }
}
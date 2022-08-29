package com.example.todolistyandex.todoedit.presentation.stateholders

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.todoedit.domain.usecase.AddTaskItemUseCase
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import kotlinx.coroutines.launch

class TaskEditViewModel(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val addTaskItemUseCase: AddTaskItemUseCase
) : ViewModel() {

    fun insert(task: Task) = viewModelScope.launch {
        Log.e("MMM1", "Task in VM: $task")
        addTaskItemUseCase(task)
    }

//    fun addTask(task: Task) {
//        addTaskItemUseCase.execute(task)
//    }
}
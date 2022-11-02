package com.example.feature_todoedit.impl.presentation.stateholders

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.Task
import com.example.feature_todoedit.impl.domain.usecase.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.DeleteTaskUseCase
import kotlinx.coroutines.launch

class TaskEditViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {

    fun insert(task: Task) = viewModelScope.launch {
        Log.e("MMM", "Task in VM: $task")
        addTaskUseCase(task)
    }

    fun delete(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase(task.id)
        }
    }
}
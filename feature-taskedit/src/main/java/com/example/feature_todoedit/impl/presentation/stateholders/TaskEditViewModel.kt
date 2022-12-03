package com.example.feature_todoedit.impl.presentation.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.Task
import com.example.core_utils.datawrappers.Result
import com.example.feature_todoedit.impl.domain.usecase.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.DeleteTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.GetTaskByIdUseCase
import com.example.feature_todoedit.impl.domain.usecase.UpdateTaskUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TaskEditViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTaskByIdUseCase: GetTaskByIdUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {

    private var _currentTaskLD = MutableLiveData<Result<Task>>()
    val currentTaskLD: LiveData<Result<Task>> = _currentTaskLD

    fun insert(task: Task) = viewModelScope.launch {
        Log.e("MMM", "Task in VM: $task")
        addTaskUseCase(task)
    }

    fun getById(id: String) {
        viewModelScope.launch {
            val result = getTaskByIdUseCase(id).first()
            when (result) {
                is Result.Success -> Log.e("MMM", "Id in TaskEditViewModel: $id result $result")
                is Result.Error -> Log.e("MMM", "ERROR")
            }
            _currentTaskLD.value = result
        }
    }

    fun update(task: Task) = viewModelScope.launch {
        updateTaskUseCase(task)
    }

    fun delete(task: Task) = viewModelScope.launch {
        deleteTaskUseCase(task.id)
    }

}
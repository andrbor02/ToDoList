package com.example.todolistyandex.todolist.presentation.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import com.example.todolistyandex.todolist.domain.usecase.UpdateTaskCompletionUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksListViewModel @Inject constructor(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskCompletionUseCase: UpdateTaskCompletionUseCase
) : ViewModel() {

    private var _taskListLD = MutableLiveData<List<Task>>()
    val taskListLD: LiveData<List<Task>> = _taskListLD

    init {
        viewModelScope.launch {
            val list = getTaskListUseCase()
            list.collect {
                Log.e("MMM", "$it")
                _taskListLD.value = it
            }
        }
    }

    fun changeTaskCompletion(task: Task, isCompleted: Boolean) {
        viewModelScope.launch {
            val updatedTask = task.copy(completion = isCompleted)
            updateTaskCompletionUseCase(updatedTask)
        }
    }

    fun visibilityChanged() {
        // TODO: filter tasks by visibility
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("MMM", "ListViewModel cleared")
    }
}
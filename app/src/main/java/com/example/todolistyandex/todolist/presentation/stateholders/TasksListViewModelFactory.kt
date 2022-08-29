package com.example.todolistyandex.todolist.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import com.example.todolistyandex.todolist.domain.usecase.UpdateTaskCompletionUseCase
import javax.inject.Inject

class TasksListViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var getTaskListUseCase: GetTaskListUseCase

    @Inject
    lateinit var updateTaskCompletionUseCase: UpdateTaskCompletionUseCase

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TasksListViewModel::class)
        return TasksListViewModel(
            getTaskListUseCase = getTaskListUseCase,
            updateTaskCompletionUseCase = updateTaskCompletionUseCase
        ) as T
    }
}
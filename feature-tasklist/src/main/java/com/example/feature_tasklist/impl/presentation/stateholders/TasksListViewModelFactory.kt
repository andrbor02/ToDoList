package com.example.feature_tasklist.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_tasklist.impl.domain.usecase.GetTaskListUseCase
import com.example.feature_tasklist.impl.domain.usecase.UpdateTaskCompletionUseCase
import javax.inject.Inject

class TasksListViewModelFactory @Inject constructor (
    private val updateTaskCompletionUseCase: UpdateTaskCompletionUseCase,
    private val getTaskListUseCase: GetTaskListUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TasksListViewModel::class)
        return TasksListViewModel(
            getTaskListUseCase = getTaskListUseCase,
            updateTaskCompletionUseCase = updateTaskCompletionUseCase
        ) as T
    }
}
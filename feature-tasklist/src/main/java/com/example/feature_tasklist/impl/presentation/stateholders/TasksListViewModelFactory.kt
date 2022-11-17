package com.example.feature_tasklist.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_tasklist.impl.domain.usecase.ChangeCompletedVisibilityUseCase
import com.example.feature_tasklist.impl.domain.usecase.GetTaskListUseCase
import com.example.feature_tasklist.impl.domain.usecase.UpdateTaskCompletionUseCase
import javax.inject.Inject

class TasksListViewModelFactory @Inject constructor(
    private val updateTaskCompletionUseCase: UpdateTaskCompletionUseCase,
    private val getTaskListUseCase: GetTaskListUseCase,
    private val changeCompletedVisibilityUseCase: ChangeCompletedVisibilityUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TasksListViewModel::class)
        return TasksListViewModel(
            getTaskListUseCase = getTaskListUseCase,
            updateTaskCompletionUseCase = updateTaskCompletionUseCase,
            changeCompletedVisibilityUseCase = changeCompletedVisibilityUseCase
        ) as T
    }
}
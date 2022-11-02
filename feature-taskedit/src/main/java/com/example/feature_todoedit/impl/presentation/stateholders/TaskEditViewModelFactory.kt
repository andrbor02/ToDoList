package com.example.feature_todoedit.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_todoedit.impl.domain.usecase.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.DeleteTaskUseCase
import javax.inject.Inject

class TaskEditViewModelFactory @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TaskEditViewModel::class)
        return TaskEditViewModel(
            addTaskUseCase = addTaskUseCase,
            deleteTaskUseCase = deleteTaskUseCase,
        ) as T
    }

}
package com.example.feature_todoedit.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_todoedit.impl.domain.usecase.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.DeleteTaskUseCase
import com.example.feature_todoedit.impl.domain.usecase.GetTaskByIdUseCase
import com.example.feature_todoedit.impl.domain.usecase.UpdateTaskUseCase
import javax.inject.Inject

class TaskEditViewModelFactory @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTaskByIdUseCase: GetTaskByIdUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TaskEditViewModel::class)
        return TaskEditViewModel(
            addTaskUseCase = addTaskUseCase,
            getTaskByIdUseCase = getTaskByIdUseCase,
            deleteTaskUseCase = deleteTaskUseCase,
            updateTaskUseCase = updateTaskUseCase
        ) as T
    }

}
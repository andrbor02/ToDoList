package com.example.todolistyandex.todoedit.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.todoedit.domain.usecase.AddTaskItemUseCase
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import javax.inject.Inject

class TaskEditViewModelFactory @Inject constructor(
    repository: TaskRepository
) : ViewModelProvider.Factory {

    private val addTaskItemUseCase by lazy(LazyThreadSafetyMode.NONE) {
        AddTaskItemUseCase(taskRepository = repository)
    }

    private val getTaskListUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetTaskListUseCase(taskRepository = repository)
    }

//    @Inject
//    lateinit var getTaskListUseCase: GetTaskListUseCase

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TaskEditViewModel::class)
        return TaskEditViewModel(
            getTaskListUseCase = getTaskListUseCase,
            addTaskItemUseCase = addTaskItemUseCase
        ) as T
    }

}
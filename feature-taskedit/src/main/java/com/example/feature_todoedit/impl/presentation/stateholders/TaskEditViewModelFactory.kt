package com.example.feature_todoedit.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core_data.api.TaskRepository
import com.example.core_data.impl.datasource.logger.LoggerTaskDataSource
import com.example.feature_todoedit.impl.domain.AddTaskUseCase
import com.example.feature_todoedit.impl.domain.DeleteTaskUseCase
import javax.inject.Inject

class TaskEditViewModelFactory @Inject constructor(
//private val hardcodedTaskDataSource: TaskDataSource,
//private val repository: TaskRepository
    private val loggerTaskDataSource: LoggerTaskDataSource,
    private val repository: TaskRepository,
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModelProvider.Factory {

//    @Inject
//    lateinit var hardcodedTaskDataSource: HardcodedTaskDataSource
    //val hardcodedTaskDataSource = HardcodedTaskDataSource()

//    private val addTaskUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        AddTaskUseCase(taskRepository = repository)
//    }

//    private val getTaskListUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        GetTaskListUseCase(taskRepository = repository)
//    }

//    @Inject
//    lateinit var getTaskListUseCase: GetTaskListUseCase

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TaskEditViewModel::class)
        return TaskEditViewModel(
//            getTaskListUseCase = getTaskListUseCase,
            addTaskUseCase = addTaskUseCase,
            deleteTaskUseCase = deleteTaskUseCase,
            loggerTaskDataSource = loggerTaskDataSource,
            repository = repository
        ) as T
    }

}
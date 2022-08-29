package com.example.todolistyandex.todolist.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolistyandex.app.data.repository.TaskRepository
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import com.example.todolistyandex.todolist.domain.usecase.UpdateTaskCompletionUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

class TasksListViewModelFactory @Inject constructor(
    private val repository: TaskRepository
    //context: Context
) : ViewModelProvider.Factory {

    private val applicationScope = CoroutineScope(SupervisorJob())

//    @Inject
//    lateinit var dbStorage: RoomDatabaseTaskStorage
//
//    @Inject
//    lateinit var hardcodedStorage: HardcodedTaskDataSource

//    @Inject
//    lateinit var repositoryoo: TaskRepository


    @Inject
    lateinit var getTaskListUseCase: GetTaskListUseCase

    @Inject
    lateinit var updateTaskCompletionUseCase: UpdateTaskCompletionUseCase


//    private val dbStorage by lazy { RoomDatabaseTaskStorage.getDatabase(context, applicationScope) }
//    private val hardcodedStorage by lazy { HardcodedTaskDataSource() }
//    val repository by lazy { TaskRepositoryImpl(
//        hardcodedStorage,
//        dbStorage.taskDao()
//    ) }

//    private val getTaskListUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        GetTaskListUseCase(taskRepository = repositoryoo)
//    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == TasksListViewModel::class)
        return TasksListViewModel(
            getTaskListUseCase = getTaskListUseCase,
            updateTaskCompletionUseCase = updateTaskCompletionUseCase
        ) as T
    }
}
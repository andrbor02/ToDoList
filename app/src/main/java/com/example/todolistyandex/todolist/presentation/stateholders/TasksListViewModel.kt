package com.example.todolistyandex.todolist.presentation.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.todolist.domain.usecase.GetTaskListUseCase
import com.example.todolistyandex.todolist.domain.usecase.UpdateTaskCompletionUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksListViewModel @Inject constructor(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskCompletionUseCase: UpdateTaskCompletionUseCase
    //private val repository: TaskRepository
) : ViewModel() {

    private var _taskListLD = MutableLiveData<List<Task>>()
    val taskListLD: LiveData<List<Task>> = _taskListLD

    init {

//        val appComponent = DaggerAp
//        Log.e("MMM", "0000${appComponent.hardcodedTaskStorage.taskList.value}")


        viewModelScope.launch {
            delay(1000)
            val list = getTaskListUseCase()
//            Log.e("MMM", "Live Data value: ${list.value}")
//            _taskListLD.value = list.value
            list.collect {
                Log.e("MMM", "$it")
                _taskListLD.value = it
            }
        }

        //viewModelScope.launch {
//            delay(3000)
////            repository.taskList.collect({
////                Log.e("MMM", "Live Data value: ${it}")
////            })
//
//            Log.e("MMM", "Live Data value: ${repository.taskList.first()}")
//
//
//            Log.e("MMM", "Previous Live Data value: ${taskListLD.value}")
//            _taskListLD.value = listOf(Task("f", "f", TaskPriority.None, completion = true, creationDate = "f"))//repository.taskList.asLiveData() as MutableLiveData<List<Task>>
//            Log.e("MMM", "Next Live Data value: ${taskListLD.value}")

        //}

//        viewModelScope.launch {
//            delay(3000)
//            _taskListLD.value = listOf(Task("fa", "f", TaskPriority.None, "f", true, "fa", "df"))
//            delay(3000)
//            _taskListLD.value = listOf(Task("ffga", "f", TaskPriority.None, "f", true, "fa", "df"))
//        }
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
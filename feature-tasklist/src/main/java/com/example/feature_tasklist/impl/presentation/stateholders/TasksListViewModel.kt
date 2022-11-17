package com.example.feature_tasklist.impl.presentation.stateholders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.Task
import com.example.feature_tasklist.impl.domain.usecase.ChangeCompletedVisibilityUseCase
import com.example.feature_tasklist.impl.domain.usecase.GetTaskListUseCase
import com.example.feature_tasklist.impl.domain.usecase.UpdateTaskCompletionUseCase
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksListViewModel @Inject constructor(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val updateTaskCompletionUseCase: UpdateTaskCompletionUseCase,
    private val changeCompletedVisibilityUseCase: ChangeCompletedVisibilityUseCase
) : ViewModel() {

    private var _taskListLD = MutableLiveData<List<Task>>()
    val taskListLD: LiveData<List<Task>> = _taskListLD

    private var _showCompletedLD = MutableLiveData<Boolean>()
    val showCompletedLD: LiveData<Boolean> = _showCompletedLD

    init {
        viewModelScope.launch {
            _showCompletedLD.value = changeCompletedVisibilityUseCase.getCurrent().last()

            val list = getTaskListUseCase()
            list.map { unsortedList ->
//                if (completedShow.last() == true) {
//                    unsortedList.filter { it.completion == true }
//                }

                unsortedList.sortedWith(compareBy({ it.completion }, { it.changeDate }))
                // TODO: Make sort by completion, changeDate and deadline
            }.collect { sortedList ->
                _taskListLD.value = sortedList
            }
        }
    }

    fun changeTaskCompletion(task: Task, isCompleted: Boolean) {
        viewModelScope.launch {
            val updatedTask = task.copy(completion = isCompleted)
            updateTaskCompletionUseCase(updatedTask)
        }
    }

    fun changeCompletedVisibility() {
//        _showCompletedLD.value = _showCompletedLD.value?.not()
        viewModelScope.launch {
//            if (changeCompletedVisibilityUseCase.getCurrent().last() == true) {
////                _taskListLD.value = _taskListLD.value?.filter { it.completion == true }
//                Log.e("MMM", "true")
////                _showCompletedLD.value = _showCompletedLD.value?.not()
//            } else {
////                _taskListLD.value =
//                Log.e("MMM", "false")
////                _showCompletedLD.value = _showCompletedLD.value?.not()
//            }
            _showCompletedLD.value = changeCompletedVisibilityUseCase.changeAndGet().last()
        }
    }
}
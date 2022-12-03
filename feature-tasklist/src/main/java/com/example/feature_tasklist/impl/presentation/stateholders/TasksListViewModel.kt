package com.example.feature_tasklist.impl.presentation.stateholders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.Task
import com.example.feature_tasklist.impl.domain.usecase.ChangeCompletedVisibilityUseCase
import com.example.feature_tasklist.impl.domain.usecase.GetTaskListUseCase
import com.example.feature_tasklist.impl.domain.usecase.UpdateTaskCompletionUseCase
import com.example.feature_tasklist.impl.domain.utils.TaskCompletionListFilter
import kotlinx.coroutines.flow.last
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

    private var _completedTasksNumberLD = MutableLiveData<Int>()
    val completedTasksNumberLD: LiveData<Int> = _completedTasksNumberLD

    init {
        initWithFilters()
    }

    private fun initWithFilters() {
        viewModelScope.launch {
            _showCompletedLD.value = changeCompletedVisibilityUseCase.getCurrent().last()
            val list = getTaskListUseCase()

            list.collect { unfilteredList ->
                if (changeCompletedVisibilityUseCase.getCurrent().last() == true) {
                    _taskListLD.value =
                        TaskCompletionListFilter.filterCompletedShown(unfilteredList)
                } else {
                    _taskListLD.value =
                        TaskCompletionListFilter.filterCompletedHide(unfilteredList)
                }

                _completedTasksNumberLD.value = unfilteredList.filter {
                    it.completion == true
                }.size
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
        viewModelScope.launch {
            _showCompletedLD.value = changeCompletedVisibilityUseCase.changeAndGet().last()
        }
        initWithFilters()
    }
}
package com.example.feature_todoedit.impl.domain.usecase

import android.util.Log
import com.example.core_data.api.repository.TaskRepository
import com.example.core_model.Task
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskByIdUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(id: String): Flow<Result<Task>> {
        var idLong = 0L
        try {
            idLong = id.toLong()
        } catch (e: NumberFormatException) {
            Log.e("MMM", "Cant map id to long: ${e.message}")
        }
        return repository.getById(idLong)
    }
}
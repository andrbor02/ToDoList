package com.example.core_utils.extensions

import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            if (it != null) {
                Result.Success(it)
            } else {
                Result.Error(KotlinNullPointerException("Value is null"))
            }
        }
        .catch { emit(Result.Error(it)) }
}
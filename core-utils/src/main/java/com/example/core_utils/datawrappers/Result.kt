package com.example.core_utils.datawrappers

sealed class Result<T> {

    class Success<T>(val value: T) : Result<T>()

    class Error<T>(val exception: Throwable) : Result<T>()

//    class Loading<T>: Result<T>()

    fun <R> map(mapper: ((T) -> R)? = null): Result<R> {
        return when (this) {
            is Success<T> -> {
                if (mapper == null) {
                    throw IllegalStateException("Can't map Success<T> result without mapper.")
                } else {
                    Success(mapper(this.value))
                }
            }
            is Error<T> -> Error(this.exception)
        }
    }

    override fun toString(): String {
        return when (this) {
            is Success -> this.value.toString()
            is Error -> this.exception.toString()
        }
    }
}
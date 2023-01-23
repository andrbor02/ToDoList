package com.example.core_database.impl.exception

sealed class LocalDataSourceException(override val message: String) : Exception() {

    class TaskByIdNotFoundException(id: Long) : LocalDataSourceException(id.toString())
}
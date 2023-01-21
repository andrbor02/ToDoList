package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DatabaseTask
import com.example.core_model.Task

interface Mappers {
    interface DataToDomainTaskMapper {
        operator fun invoke(databaseTask: DatabaseTask): Task
    }

    interface DomainToDataTaskMapper {
        operator fun invoke(task: Task): DatabaseTask
    }

}
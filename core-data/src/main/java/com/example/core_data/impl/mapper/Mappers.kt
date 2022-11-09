package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task

interface Mappers {
    interface DataToDomainTaskMapper {
        operator fun invoke(dbTask: DBTask): Task
    }

    interface DomainToDataTaskMapper {
        operator fun invoke(task: Task): DBTask
    }

}
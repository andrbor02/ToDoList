package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import org.junit.Assert.assertEquals
import org.junit.Test

class DataToDomainTaskMapperTest {

    @Test
    fun testMapperNonePriority() {
        val mapper = DataToDomainTaskMapper()
        val dbTask = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Нет",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.None,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(dbTask)

        assertEquals(expected, actual)
    }


    @Test
    fun testMapperLowPriority() {
        val mapper = DataToDomainTaskMapper()
        val dbTask = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Низкий",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.Low,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(dbTask)

        assertEquals(expected, actual)
    }


    @Test
    fun testMapperHighPriority() {
        val mapper = DataToDomainTaskMapper()
        val dbTask = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Высокий",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.High,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(dbTask)

        assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testMapperInvalid() {
        val mapper = DataToDomainTaskMapper()
        val dbTask = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Случайный приоритет",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.None,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(dbTask)

        assertEquals(expected, actual)
    }
}
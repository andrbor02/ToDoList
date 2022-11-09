package com.example.core_data.impl.mapper

import com.example.core_data.impl.model.DBTask
import com.example.core_model.Task
import com.example.core_model.TaskPriority
import org.junit.Assert.assertEquals
import org.junit.Test

class DomainToDataTaskMapperTest {

    @Test
    fun testMapperNonePriority() {
        val mapper = DomainToDataTaskMapper()
        val task = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.None,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Нет",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(task)

        assertEquals(expected, actual)
    }

    @Test
    fun testMapperLowPriority() {
        val mapper = DomainToDataTaskMapper()
        val task = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.Low,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Низкий",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(task)

        assertEquals(expected, actual)
    }

    @Test
    fun testMapperHighPriority() {
        val mapper = DomainToDataTaskMapper()
        val task = Task(
            id = 41328934,
            description = "Test task",
            priority = TaskPriority.High,
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )

        val expected = DBTask(
            id = 41328934,
            text = "Test task",
            priority = "Высокий",
            deadline = "01.01.1980",
            completion = true,
            creationDate = "01.01.1970",
            changeDate = "01.02.1970"
        )
        val actual = mapper(task)

        assertEquals(expected, actual)
    }
}
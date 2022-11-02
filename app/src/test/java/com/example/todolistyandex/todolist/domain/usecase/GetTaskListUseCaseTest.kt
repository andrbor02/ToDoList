package com.example.todolistyandex.todolist.domain.usecase

import com.example.core_data.impl.repository.TaskRepositoryImpl
import com.example.feature_tasklist.impl.domain.usecase.GetTaskListUseCase
import com.example.todolistyandex.TaskListProducer
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GetTaskListUseCaseTest {

    val taskListProducer = TaskListProducer()

    @Test
    fun shouldReturnRepositoryData() {
        val repository = mockk<TaskRepositoryImpl>()
        every { repository.getAll() } returns flowOf(
            taskListProducer.getHugeTaskList()
        )
        val getTaskListUseCase = GetTaskListUseCase(repository)

//        every { repository.get() } returnsMany(listOf(
//            flowOf(
//                taskListProducer.getEmptyTaskList(),
//                taskListProducer.getSmallTaskList(),
//                taskListProducer.getHugeTaskList()
//            )
//        ))

        val excepected = repository.getAll()

        val actual = getTaskListUseCase.invoke()

        //verifySequence { getTaskListUseCase.invoke(any()) }
        assertEquals(excepected, actual)
    }

//    private fun mockRepository(): TaskRepository{
//        val repository = mockk<TaskRepositoryImpl>()
//        every { repository.get() } returns flowOf(
//            taskListProducer.getHugeTaskList()
//        )
//        return repository
//    }
}
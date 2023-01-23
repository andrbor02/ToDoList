package com.example.core_network.impl.datasource.retrofit

import android.util.Log
import com.example.core_network.impl.datasource.TaskRemoteDataSource
import com.example.core_network.impl.model.NetworkTask
import com.example.core_network.impl.model.NetworkTaskWithId
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import javax.inject.Inject

class TaskRemoteDataSourceImpl @Inject constructor(
    private val taskApi: TaskApi,
) : TaskRemoteDataSource {
    override suspend fun insertTask(task: NetworkTaskWithId) {
        taskApi.addTask(task.id, task.task)
    }

    override suspend fun updateTask(task: NetworkTaskWithId) {

    }

    override suspend fun deleteTask(taskId: Long) {

    }

    override suspend fun getTaskList(): Flow<Result<List<NetworkTask>>> {
        return flowOf(
            Result.Success(
                listOf(
                    NetworkTask(
                        "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
                        "High",
                        "13.05.2020",
                        false,
                        "34.99.22",
                        "12.34.5678"
                    ),
                    NetworkTask(
                        "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
                        "High",
                        "13.05.2020",
                        false,
                        "34.99.22",
                        "12.34.5678"
                    )
                )
            )
        )
//        taskApi.getTaskList()
    }

    override suspend fun getTaskById(taskId: Long): Flow<Result<NetworkTask>> {
        return flowOf(
            Result.Success(
                taskApi.getTaskById(taskId.toString()).await()
            )
        )
    }

    override fun synchronizeTaskList(map: Map<String, NetworkTask>) {
        Log.e("MMA", "Synchronization begins")
        taskApi.synchronizeTaskList(map).enqueue(MySyncCallback())
    }
}

class MySyncCallback : Callback<Map<String, NetworkTask>> {
    override fun onResponse(
        call: Call<Map<String, NetworkTask>>,
        response: Response<Map<String, NetworkTask>>
    ) {
        Log.e("MMMMM", "Loaded ${response.body()?.entries?.joinToString(" ")}")
    }

    override fun onFailure(
        call: Call<Map<String, NetworkTask>>,
        t: Throwable
    ) {
        Log.e("MMMMM", "${t.message}")
    }
}
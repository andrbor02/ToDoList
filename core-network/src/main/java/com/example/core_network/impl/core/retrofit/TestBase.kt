package com.example.core_network.impl.core.retrofit

import android.util.Log
import com.example.core_network.impl.core.model.NetworkTask
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object TestBase {

    fun test() {
        val taskApi = RetrofitTestApp().configureAndGet()
        taskApi.addTask(
            "25", NetworkTask(
                "дела должны быть максимально разнообразны, чтобы покрыть все комбинации возможных значений и проверить работу экрана наиболее полным образом",
                "High",
                "13.05.2020",
                false,
                "34.99.22",
                "12.34.5678"
            )
        )?.enqueue(MyCallback())
//        taskApi.getTaskList().enqueue(MyCallback())


//        taskApi.deleteTask("25").enqueue(MyCallback())

//        taskApi.updateTask("25", NetworkTask(
//            "дела должна полным образом",
//            "High",
//            "13.05.2023",
//            true,
//            "34.99.22",
//            "12.34.5678"
//        ))?.enqueue(MyCallback())
    }
}


class MyCallback<TaskListResponse> : Callback<TaskListResponse> {
    override fun onResponse(call: Call<TaskListResponse>, response: Response<TaskListResponse>) {
        val res: TaskListResponse? = response.body()
        Log.e("MMMMM", res.toString())
    }

    override fun onFailure(call: Call<TaskListResponse>, t: Throwable) {
        Log.e("MMMMM", t.toString())
    }
}
package com.example.todolistyandex.routing

import android.content.Context
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.example.feature_tasklist.impl.presentation.navigation.TasksListNavigation
import com.example.feature_todoedit.R
import com.example.feature_todoedit.api.TaskEditApi
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(
    private val featureTaskEdit: Provider<TaskEditApi>,
//    private val featureTaskList: Provider<TaskListApi>,
    private val context: Context
): TasksListNavigation {

    private var navContr: NavController? = null

    @Inject
    lateinit var uriCreator: UriCreator

    override fun addNewTask() {
        featureTaskEdit.get().starter().start()
        val uri = uriCreator.create(
            uriRes = R.string.uri_task_edit_expect_argument
        )

        val request = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        navContr?.navigate(request)
    }

    override fun editExistingTask(taskId: Long) {
        featureTaskEdit.get().starter().start()
        val uri = uriCreator.createWithArgs(
            uriRes = R.string.uri_task_edit_expect_argument,
            argsPlaceHolderRes = R.string.task_id,
            args = taskId.toString()
        )
        val request = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        Log.e("MMM", "Navigator edit existing: taskId $taskId and uri $uri")
        navContr?.navigate(request)
    }


    fun bind(navController: NavController) {
        navContr = navController
        Log.e("MMMM", "NavController bind")
    }

    fun unbind() {
        navContr = null
        Log.e("MMMM", "NavController unbind")
    }
}
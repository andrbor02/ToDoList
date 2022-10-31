package com.example.todolistyandex.routing

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
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

//    fun goToTaskEditFeature(view: View, context: Context) {
////        featureTaskEdit.get().starter().start(view, context)
//        featureTaskEdit.get().starter().start(view, context)
//    }


//    override fun addNewTask(view: View, context: Context) {
//        featureTaskEdit.get().starter().start(view, context)
//    }

    override fun addNewTask() {
        featureTaskEdit.get().starter().start()
        val request = NavDeepLinkRequest.Builder
            .fromUri(context.getString(R.string.uri_task_edit).toUri())
            .build()
        navContr?.navigate(request)

        Log.e("MMMM", "NAVIGATed", )
    }

    override fun editExistingTask(taskId: String) {
        TODO("Not yet implemented")
    }


    fun bind(navController: NavController) {
        navContr = navController
        Log.e("MMMM", "NAVIGATOR bind", )
    }

    fun unbind() {
        navContr = null
        Log.e("MMMM", "NAVIGATOR unbind", )
    }
}
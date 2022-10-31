package com.example.feature_tasklist.impl.presentation.routing

import android.content.Context
import android.view.View
import com.example.feature_tasklist.api.TaskListApi
import javax.inject.Inject
import javax.inject.Provider

//@Singleton
class Navigator @Inject constructor(
    private val featureTaskEdit: Provider<TaskListApi>,
//    private val taskEditA
    private val context: Context
) {

    fun goToTaskEditFeature(view: View, context: Context) {
//        taskEditApi.starter().start(context)
//        featureTaskEdit.get().starter().start(view, context)
//        featureTaskEdit.get().starter().start()
    }
}
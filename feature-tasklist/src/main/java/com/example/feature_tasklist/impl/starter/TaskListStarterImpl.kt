package com.example.feature_tasklist.impl.starter

import com.example.core_utils.annotations.PerFeature
import com.example.feature_tasklist.api.TaskListStarter

@PerFeature
class TaskListStarterImpl : TaskListStarter {

    //    override fun start(view: View, context: Context) {
//        val request = NavDeepLinkRequest.Builder
//            .fromUri(context.getString(R.string.uri_task_list).toUri())
//            .build()
//        view.findNavController().navigate(request)
//    }
    override fun start() {}
}
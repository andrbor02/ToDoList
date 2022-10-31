package com.example.todolistyandex.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.feature_tasklist.api.TaskListApi
import com.example.todolistyandex.R
import com.example.todolistyandex.app.App
import com.example.todolistyandex.routing.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var taskListApi: TaskListApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).
        appComponent.injectToMainActivity(this)
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.main_nav_host))
    }

    override fun onPause() {
        super.onPause()
        navigator.unbind()
    }
}
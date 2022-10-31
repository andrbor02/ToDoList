package com.example.core_data.impl.datasource.logger

import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor() {
    fun log(){
        Log.e("MMMM", "Logger is here")
    }
}
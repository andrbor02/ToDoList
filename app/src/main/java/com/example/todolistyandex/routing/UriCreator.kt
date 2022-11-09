package com.example.todolistyandex.routing

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import javax.inject.Inject

class UriCreator @Inject constructor(
    private val context: Context
) {

    fun create(uriRes: Int): Uri {
        val path = context.getString(uriRes)
        return path.toUri()
    }

    fun createWithArgs(uriRes: Int, argsPlaceHolderRes: Int, args: String): Uri {
        val pathExpectArgs = context.getString(uriRes)
        val argsPlaceHolder = context.getString(argsPlaceHolderRes)
        val pathWithArgs = pathExpectArgs.replace(
            oldValue = "{$argsPlaceHolder}",
            newValue = args
        )
        return pathWithArgs.toUri()
    }
}
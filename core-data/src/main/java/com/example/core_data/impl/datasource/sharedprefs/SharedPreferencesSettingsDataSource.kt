package com.example.core_data.impl.datasource.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class SharedPreferencesSettingsDataSource @Inject constructor(
    context: Context
) {
    private val showCompletedKey = "SHOW_COMPLETED_FLAG"
    private val settingsPreference: SharedPreferences =
        context.getSharedPreferences(showCompletedKey, Context.MODE_PRIVATE)

    fun setShowCompletedFlag(isShown: Boolean) {
        val editor = settingsPreference.edit()
        editor.putBoolean(showCompletedKey, isShown)
        editor.apply()
    }

    // TODO: Handle if value doesn't exist
    fun getShowCompletedFlag() = flowOf(
        settingsPreference.getBoolean(showCompletedKey, true)
    )
}
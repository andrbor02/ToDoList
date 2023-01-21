package com.example.core_data.impl.datasource.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import com.example.core_database.impl.datasource.SettingsDataSource
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class SharedPreferencesSettingsDataSource @Inject constructor(
    context: Context
) : SettingsDataSource {
    private val showCompletedKey = "SHOW_COMPLETED_FLAG"
    private val settingsPreference: SharedPreferences =
        context.getSharedPreferences(showCompletedKey, Context.MODE_PRIVATE)

    override fun setShowCompletedFlag(isShown: Boolean) {
        val editor = settingsPreference.edit()
        editor.putBoolean(showCompletedKey, isShown)
        editor.apply()
    }

    // TODO: Handle if value doesn't exist
    override fun getShowCompletedFlag() = flowOf(
        settingsPreference.getBoolean(showCompletedKey, true)
    )
}
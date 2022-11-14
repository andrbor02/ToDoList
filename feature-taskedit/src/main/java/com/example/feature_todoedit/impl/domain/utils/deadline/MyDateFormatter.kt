package com.example.feature_todoedit.impl.domain.utils.deadline

import android.icu.text.SimpleDateFormat
import java.util.*

object MyDateFormatter {
    fun format(date: Date): String {
        val myFormat = "dd.MM.yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat, Locale.US)
        return simpleDateFormat.format(date)
    }
}
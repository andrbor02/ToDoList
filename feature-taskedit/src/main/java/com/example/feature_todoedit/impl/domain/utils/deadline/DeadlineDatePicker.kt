package com.example.feature_todoedit.impl.domain.utils.deadline

import android.app.DatePickerDialog
import android.content.Context
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding
import java.util.*

class DeadlineDatePicker(
    private val context: Context,
    private val binding: FragmentTaskEditBinding
) {

    private val cal: Calendar = Calendar.getInstance()

    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            binding.taskDeadline.text = MyDateFormatter.format(cal.time)
        }

    fun show() {
        DatePickerDialog(
            context,
            dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}
package com.example.feature_todoedit.impl.domain.utils.deadline

import android.content.Context
import com.example.feature_todoedit.databinding.FragmentTaskEditBinding
import java.util.*

class DeadlineController(
    private val context: Context,
    private val binding: FragmentTaskEditBinding
) {
    private val deadlineDatePicker = DeadlineDatePicker(context, binding)
    private val cal: Calendar = Calendar.getInstance()


    init {
        setCurrentDeadline()
    }

    private fun setCurrentDeadline() {
        binding.taskDeadline.text = MyDateFormatter.format(cal.time)
    }

    fun changeDeadline() {
        deadlineDatePicker.show()
    }
}
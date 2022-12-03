package com.example.feature_tasklist.impl.presentation.recycler

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.core_model.Task
import com.example.core_ui.R
import com.example.feature_tasklist.databinding.TaskItemBinding
import com.example.todolistyandex.todolist.presentation.recycler.TaskClickListener

class TasksListViewHolder(
    private val binding: TaskItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("ResourceAsColor")
    fun bindTask(task: Task, listener: TaskClickListener) {
        binding.apply {
            taskName.text = task.description
            //binding.taskPriorityIcon
            taskDeadline.text = task.deadline
            if (task.completion == true) {
                taskName.paintFlags = taskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                taskName.setTextColor(R.color.label_tertiary)
                taskDeadline.setTextColor(R.color.label_tertiary)
            }
            taskCompletionCb.isChecked = task.completion
            taskCompletionCb.setOnClickListener {
                listener.onCheckboxClick(task, taskCompletionCb.isChecked)
            }
            taskInfoBut.setOnClickListener { listener.onItemClick(task) }
        }
    }
}
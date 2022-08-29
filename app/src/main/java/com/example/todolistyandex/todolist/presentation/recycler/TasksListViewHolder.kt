package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.databinding.TaskItemBinding

class TasksListViewHolder(
    private val binding: TaskItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bindTask(task: Task, listener: TaskClickListener) {
        binding.apply {
            taskName.text = task.text
            //binding.taskPriorityIcon
            taskDeadline.text = task.deadline
            taskCompletionCb.isChecked = task.completion

            taskCompletionCb.setOnClickListener {
                listener.onCheckboxClick(task, taskCompletionCb.isChecked)
            }
            taskInfoBut.setOnClickListener { listener.onItemClick(task) }
        }
    }
}
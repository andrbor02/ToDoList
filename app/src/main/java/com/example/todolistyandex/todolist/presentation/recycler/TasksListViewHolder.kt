package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.todolistyandex.app.domain.model.Task
import com.example.todolistyandex.databinding.TaskItemBinding
import com.example.todolistyandex.todolist.presentation.stateholders.TasksListViewModel

class TasksListViewHolder(
    private val viewModel: TasksListViewModel,
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


//val id: String,
//val text: String,
//val priority: TaskPriority,
//val deadline: String = "",
//val completion: Boolean,
//val creationDate: String,
//val changeDate: String = ""
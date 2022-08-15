package com.example.todolistyandex.todolist.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.todolistyandex.databinding.TaskItemBinding
import com.example.todolistyandex.todolist.presentation.TasksListViewModel
import com.example.todolistyandex.todolist.presentation.model.Task

class TasksListViewHolder(
    viewModel: TasksListViewModel,
    private val binding: TaskItemBinding
) : RecyclerView.ViewHolder(binding.root) {



    fun bindTask(task: Task) {
        binding.taskName.text = task.text
        //binding.taskPriorityIcon
        binding.taskDeadline.text = task.deadline
        binding.taskCompletionCb.isChecked = task.completion
    }
}


//val id: String,
//val text: String,
//val priority: TaskPriority,
//val deadline: String = "",
//val completion: Boolean,
//val creationDate: String,
//val changeDate: String = ""
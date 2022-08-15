package com.example.todolistyandex.todolist.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.todolistyandex.databinding.TodoItemBinding
import com.example.todolistyandex.todolist.presentation.TasksListViewModel
import com.example.todolistyandex.todolist.presentation.model.TodoItem

class TasksListAdapter(
    private val viewModel: TasksListViewModel,
    tasksListDiffUtil: TasksListDiffUtil,
    private val todoItems: ArrayList<TodoItem>
    ) :
    ListAdapter<TodoItem, TasksListViewHolder>(tasksListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksListViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_task, parent, false)

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTaskBinding = TodoItemBinding.inflate(layoutInflater, parent, false)

        return TasksListViewHolder(viewModel, itemTaskBinding)
    }

    override fun onBindViewHolder(holder: TasksListViewHolder, position: Int) {
        holder.bindTask(todoItems[position]/*Task(44, "asdfdf", "adsff", TaskPriority.High(), true)*/)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }
}
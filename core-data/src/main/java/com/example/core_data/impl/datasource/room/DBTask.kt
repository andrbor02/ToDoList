package com.example.core_data.impl.datasource.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class DBTask(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    val id: Long,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "priority")
    val priority: String, //TaskPriority
    @ColumnInfo(name = "deadline")
    val deadline: String = "",
    @ColumnInfo(name = "completion")
    val completion: Boolean,
    @ColumnInfo(name = "creation_date")
    val creationDate: String,
    @ColumnInfo(name = "change_date")
    val changeDate: String = ""
)
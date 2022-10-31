package com.example.todolistyandex.data.repository

//class TaskRepositoryImpl /*@Inject constructor*/(
//    private val hardcodedTaskStorage: HardcodedTaskDataSource,
//    private val taskDao: TaskDao
//) : TaskRepository {
//
//    private val dbTaskList: Flow<List<DBTask>> = taskDao.getTasks()
//
//    override val taskList: Flow<List<Task>> = dbTaskList.map { dblist ->
//        dblist.map { DBTask ->
//            mapDataToDomain(DBTask)
//        }
//    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    override suspend fun insert(task: Task) {
//        if (task.text.isBlank()) {
//            return
//        }
//        val dbTask = mapDomainToData(task)
//        Log.e("MMM1", "DBTASK added: $task")
//        taskDao.insertTask(dbTask)
//    }
//
//    @WorkerThread
//    override suspend fun update(task: Task) {
//        val dbTask = mapDomainToData(task)
//        taskDao.updateTask(dbTask)
//    }
//
//    override suspend fun delete(id: String) {
//       taskDao.deleteTask()
//    }
//
//    override fun get(): Flow<List<Task>> {
//        return taskList
//    }
//
//    private fun mapDomainToData(task: Task): DBTask {
//        val taskPriority = when (task.priority) {
//            TaskPriority.None -> TaskPriority.None.title
//            TaskPriority.Low -> TaskPriority.Low.title
//            TaskPriority.High -> TaskPriority.High.title
//        }
//
//        return DBTask(
//            task.id.toLong(),
//            task.text,
//            taskPriority,
//            task.deadline,
//            task.completion,
//            task.creationDate,
//            task.changeDate
//        )
//    }
//
//    private fun mapDataToDomain(dbTask: DBTask): Task {
//        val taskPriority = when (dbTask.priority) {
//            TaskPriority.None.title -> TaskPriority.None
//            TaskPriority.Low.title -> TaskPriority.Low
//            TaskPriority.High.title -> TaskPriority.High
//            else -> TaskPriority.None
////            else -> throw IllegalArgumentException("Wrong task priority from DB")
//        }
//
//        return Task(
//            dbTask.id.toString(),
//            dbTask.text,
//            taskPriority,
//            dbTask.deadline,
//            dbTask.completion,
//            dbTask.creationDate,
//            dbTask.changeDate
//        )
//    }
//}
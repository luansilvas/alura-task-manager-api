package br.com.lss.taskManager.data

data class SubTask(
    val id: Long? = null,
    val title: String,
    val status: StatusTask = StatusTask.TO_DO,
    val task: Task? = null
)
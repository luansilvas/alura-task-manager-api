package br.com.lss.taskManager.data

import java.time.LocalDateTime

data class Task(
    var id: Long? = null,
    val title: String,
    val description: String,
    val creationDate : LocalDateTime = LocalDateTime.now(),
    val institution: Institution?,
    val type: TaskType = TaskType.PERSONAL,
    val author: User?,
    val status: StatusTask = StatusTask.TO_DO,
    val subtasks: List<SubTask> = listOf(),
    val isVisible: Boolean = true
    )


package br.com.lss.taskManager.data.response

import br.com.lss.taskManager.data.StatusTask
import java.time.LocalDateTime

data class TaskResponse(
    val id: Long?,
    val title: String,
    val description: String,
    val status: StatusTask,
    val creationDate: LocalDateTime
)
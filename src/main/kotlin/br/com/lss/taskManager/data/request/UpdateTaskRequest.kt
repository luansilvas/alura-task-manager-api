package br.com.lss.taskManager.data.request

import br.com.lss.taskManager.data.SubTask
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTaskRequest(
    @field:NotNull val id: Long,
    @field:NotNull
    @field:Size(min=5, max=100)
    val title: String,
    @field:NotNull val description: String,
    @field:NotNull val subTasks: List<SubTask>?
)

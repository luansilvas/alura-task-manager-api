package br.com.lss.taskManager.data.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateTaskRequest(
    @field:NotEmpty @field:Size(min = 5, max = 600, message = "Title must have at least five characters and 600 maximum") val title: String,
    @field:NotEmpty(message = "description must not be blank") val description: String,
    @field:NotNull(message = "user id must not be null") val idUser: Long,
    @field:NotNull(message = "institution must not be null") val idInstitution: Long,
    @field:NotNull(message = "subtasks list must not be null") val subTasks: List<String>
)

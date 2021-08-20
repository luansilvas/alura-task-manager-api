package br.com.lss.taskManager.util

import br.com.lss.taskManager.data.StatusTask
import br.com.lss.taskManager.data.SubTask
import br.com.lss.taskManager.data.Task
import br.com.lss.taskManager.data.TaskType
import br.com.lss.taskManager.data.request.CreateTaskRequest
import br.com.lss.taskManager.service.InstitutionService
import br.com.lss.taskManager.service.UserService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CreateTaskRequestMapper(
    private val institutionService: InstitutionService,
    private val userService: UserService,
) : Mapper<CreateTaskRequest, Task> {

    override fun map(task: CreateTaskRequest): Task {
        return Task(
            title = task.title,
            description = task.description,
            creationDate = LocalDateTime.now(),
            institution = institutionService.findInstitutionById(task.idInstitution),
            type = TaskType.PERSONAL,
            author = userService.findUserById(task.idUser),
            status = StatusTask.TO_DO,
            subtasks = task.subTasks.map {
                SubTask(
                    title = it,
                    status = StatusTask.TO_DO
                )
            },
            isVisible = true
        )
    }

}
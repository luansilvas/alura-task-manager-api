package br.com.lss.taskManager.util

import br.com.lss.taskManager.data.Task
import br.com.lss.taskManager.data.response.TaskResponse
import org.springframework.stereotype.Component

@Component
class TaskResponseMapper : Mapper<Task, TaskResponse> {
    override fun map(task: Task): TaskResponse {
        return TaskResponse(
            id = task.id,
            title = task.title,
            description = task.description,
            status = task.status,
            creationDate = task.creationDate
        )
    }
}
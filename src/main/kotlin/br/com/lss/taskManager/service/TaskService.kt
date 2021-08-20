package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.Task
import br.com.lss.taskManager.data.request.CreateTaskRequest
import br.com.lss.taskManager.data.request.UpdateTaskRequest
import br.com.lss.taskManager.data.response.TaskResponse
import br.com.lss.taskManager.exception.NotFoundException
import br.com.lss.taskManager.util.CreateTaskRequestMapper
import br.com.lss.taskManager.util.TaskResponseMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TaskService(
    private var tasks: List<Task> = ArrayList(),
    private val taskResponseMapper: TaskResponseMapper,
    private val createTaskRequestMapper: CreateTaskRequestMapper

) {
    val notFoundMessage = "Resource not found!"
    fun listTasks(): List<TaskResponse> {
        return tasks.stream().map { task ->
            taskResponseMapper.map(task)
        }.collect(Collectors.toList())
    }

    fun getTaskById(id: Long): TaskResponse {
        val task = tasks.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return taskResponseMapper.map(task)
    }

    fun register(taskRequest: CreateTaskRequest): TaskResponse {
        val task = createTaskRequestMapper.map(taskRequest)
        task.id = tasks.size.toLong() + 1
        tasks = tasks.plus(task)
        return taskResponseMapper.map(task)
    }

    fun update(task: UpdateTaskRequest): TaskResponse {
        val oldTask = tasks.stream().filter { t ->
            t.id == task.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val newTask = Task(
            id = task.id,
            title = task.title,
            description = task.description,
            subtasks = task.subTasks ?: oldTask.subtasks,
            author = oldTask.author,
            status = oldTask.status,
            isVisible = oldTask.isVisible,
            type = oldTask.type,
            institution = oldTask.institution,
            creationDate = oldTask.creationDate
        )
        tasks = tasks.minus(oldTask).plus(newTask)
        return taskResponseMapper.map(newTask)
    }

    fun delete(id: Long) {
        val task = tasks.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        tasks = tasks.minus(task)
    }
}
package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.TaskByInstitution
import br.com.lss.taskManager.data.request.CreateTaskRequest
import br.com.lss.taskManager.data.request.UpdateTaskRequest
import br.com.lss.taskManager.data.response.TaskResponse
import br.com.lss.taskManager.exception.NotFoundException
import br.com.lss.taskManager.repository.TaskRepository
import br.com.lss.taskManager.util.CreateTaskRequestMapper
import br.com.lss.taskManager.util.TaskResponseMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val repository: TaskRepository,
    private val taskResponseMapper: TaskResponseMapper,
    private val createTaskRequestMapper: CreateTaskRequestMapper
) {
    val notFoundMessage = "Resource not found!"
    fun listTasks(
        author: String?,
        pagination: Pageable
    ): Page<TaskResponse> {
        val result =
            if (author.isNullOrBlank()) repository.findAll(pagination)
            else repository.findByAuthorName(author, pagination)
        return result.map { task ->
            taskResponseMapper.map(task)
        }
    }

    fun getTaskById(id: Long): TaskResponse {
        val task = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return taskResponseMapper.map(task)
    }

    fun register(taskRequest: CreateTaskRequest): TaskResponse {
        val task = createTaskRequestMapper.map(taskRequest)
        repository.save(task)
        return taskResponseMapper.map(task)
    }

    fun update(task: UpdateTaskRequest): TaskResponse {
        val currentTask = repository.findById(task.id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        currentTask.title = task.title
        currentTask.description = task.description
        return taskResponseMapper.map(currentTask)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun generateReport(): List<TaskByInstitution> {
        return repository.report()
    }
}
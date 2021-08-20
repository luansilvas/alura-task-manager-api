package br.com.lss.taskManager.controller

import br.com.lss.taskManager.data.request.CreateTaskRequest
import br.com.lss.taskManager.data.Task
import br.com.lss.taskManager.data.request.UpdateTaskRequest
import br.com.lss.taskManager.data.response.TaskResponse
import br.com.lss.taskManager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/task")
class TaskController(
    private val taskService: TaskService
) {
    @GetMapping
    fun listTasks(): List<TaskResponse> {
        return taskService.listTasks()
    }

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable id: Long
    ): TaskResponse {
        return taskService.getTaskById(id)
    }

    @PostMapping
    fun register(
        @RequestBody @Valid task: CreateTaskRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TaskResponse>{
        val taskResponse = taskService.register(task)
        val uri = uriBuilder.path("/task/${taskResponse.id}").build().toUri()

        return ResponseEntity.created(uri).body(taskResponse)

    }

    @PutMapping
    fun update(@RequestBody @Valid task: UpdateTaskRequest): ResponseEntity<TaskResponse>{
        val taskResponse = taskService.update(task)
        return ResponseEntity.ok(taskResponse)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        taskService.delete(id)
    }
}

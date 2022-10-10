package br.com.lss.taskManager.controller

import br.com.lss.taskManager.data.request.CreateTaskRequest
import br.com.lss.taskManager.data.TaskByInstitution
import br.com.lss.taskManager.data.request.UpdateTaskRequest
import br.com.lss.taskManager.data.response.TaskResponse
import br.com.lss.taskManager.service.TaskService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/task")
class TaskController(
    private val taskService: TaskService
) {
    @GetMapping
    @Cacheable("task list")
    fun listTasks(
        @RequestParam(required = false) author: String?,
        @PageableDefault(size=5, direction = Sort.Direction.DESC) pagination:Pageable
    ): Page<TaskResponse> {
        return taskService.listTasks(author, pagination)
    }

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable id: Long
    ): TaskResponse {
        return taskService.getTaskById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value=["task list"], allEntries = true)
    fun register(
        @RequestBody @Valid task: CreateTaskRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TaskResponse>{
        val taskResponse = taskService.register(task)
        val uri = uriBuilder.path("/task/${taskResponse.id}").build().toUri()

        return ResponseEntity.created(uri).body(taskResponse)

    }

    @PutMapping
    @Transactional
    @CacheEvict(value=["task list"], allEntries = true)
    fun update(@RequestBody @Valid task: UpdateTaskRequest): ResponseEntity<TaskResponse>{
        val taskResponse = taskService.update(task)
        return ResponseEntity.ok(taskResponse)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value=["task list"], allEntries = true)
    fun delete(@PathVariable id: Long){
        taskService.delete(id)
    }

    @GetMapping("/report")
    fun report(): List<TaskByInstitution> {
        return taskService.generateReport()
    }
}

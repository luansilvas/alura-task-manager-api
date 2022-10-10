package br.com.lss.taskManager.repository

import br.com.lss.taskManager.data.Task
import br.com.lss.taskManager.data.TaskByInstitution
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskRepository: JpaRepository<Task, Long> {

    fun findByAuthorName(author: String, pagination: Pageable): Page<Task>

    @Query("SELECT new br.com.lss.taskManager.data.TaskByInstitution(institution.name, count(t)) FROM Task t JOIN t.institution institution GROUP BY institution.name")
    fun report(): List<TaskByInstitution>
}
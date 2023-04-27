package br.com.lss.taskManager.repository

import br.com.lss.taskManager.data.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(username: String?): User?


}
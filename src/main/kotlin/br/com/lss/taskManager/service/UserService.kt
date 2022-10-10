package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.User
import br.com.lss.taskManager.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repo: UserRepository
) {

    fun findUserById(id: Long): User {
        return repo.getById(id)
    }
}
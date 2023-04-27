package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.User
import br.com.lss.taskManager.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repo: UserRepository
) : UserDetailsService {

    fun findUserById(id: Long): User {
        return repo.getById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repo.findByEmail(username) ?: throw RuntimeException()

        return UserDetail(user)
    }


}
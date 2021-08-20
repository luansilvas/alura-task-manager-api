package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.User
import org.springframework.stereotype.Service

@Service
class UserService(
    var users: List<User>
) {
    init {
        val user1 = User(
            id = 1,
            name = "Luan Santos",
            email = "luanssantos12@gmail.com"
        )
        users = listOf(user1)
    }

    fun findUserById(id: Long): User {
        return users.stream().filter { user ->
            user.id == id
        }.findFirst().get()
    }
}
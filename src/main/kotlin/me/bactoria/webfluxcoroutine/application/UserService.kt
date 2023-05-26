package me.bactoria.webfluxcoroutine.application

import me.bactoria.webfluxcoroutine.domain.User
import me.bactoria.webfluxcoroutine.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
	private val userRepository: UserRepository
) {
	suspend fun save(userId: String, password: String, name: String) {
		userRepository.save(User(userId = userId, password = password, name = name))
	}
}

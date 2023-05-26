package me.bactoria.webfluxcoroutine.ui

import me.bactoria.webfluxcoroutine.application.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
	private val userService: UserService
) {

	@PostMapping("/users")
	suspend fun save(@RequestBody request: UserSaveRequest) {
		userService.save(
			userId = request.userId,
			password = request.password,
			name = request.name
		)
	}

	data class UserSaveRequest(
		val userId: String,
		val password: String,
		val name: String,
	)
}

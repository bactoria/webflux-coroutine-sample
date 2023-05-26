package me.bactoria.webfluxcoroutine.domain

interface UserRepository {
	suspend fun save(user: User): User
}

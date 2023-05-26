package me.bactoria.webfluxcoroutine.infra

import me.bactoria.webfluxcoroutine.domain.User
import me.bactoria.webfluxcoroutine.domain.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
	private val userEntityCrudRepository: UserEntityCrudRepository
) : UserRepository {
	override suspend fun save(user: User): User {
		return user
			.let { UserEntity.from(it) }
			.let { userEntityCrudRepository.save(it) }
			.let { it.toDomain() }
	}
}

package me.bactoria.webfluxcoroutine.infra

import me.bactoria.webfluxcoroutine.domain.User
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
data class UserEntity(
	@Id
	val id: Long = 0,
	val userId: String,
	val password: String,
	val name: String,
) {

	fun toDomain() = User(
		id = id,
		userId = userId,
		password = password,
		name = name,
	)

	companion object {
		fun from(user: User) = UserEntity(
			id = user.id,
			userId = user.userId,
			password = user.password,
			name = user.name,
		)
	}
}

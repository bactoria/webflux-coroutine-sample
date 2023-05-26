package me.bactoria.webfluxcoroutine.infra

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserEntityCrudRepository: CoroutineCrudRepository<UserEntity, Long>

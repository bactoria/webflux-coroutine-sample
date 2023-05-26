package me.bactoria.webfluxcoroutine.infra.config

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

@Configuration
@EnableConfigurationProperties(R2dbcProperties::class)
class R2dbcConfig(
	private val r2dbcProperties: R2dbcProperties
) : AbstractR2dbcConfiguration() {

	@Primary
	@Bean
	override fun connectionFactory(): ConnectionFactory {
		return JasyncConnectionFactory(MySQLConnectionFactory(
			com.github.jasync.sql.db.Configuration(
				host = r2dbcProperties.host,
				port = r2dbcProperties.port,
				database = r2dbcProperties.database,
				username = r2dbcProperties.username,
				password = r2dbcProperties.password,
			)))
	}
}

@ConfigurationProperties(prefix = "r2dbc")
data class R2dbcProperties(
	val host: String,
	val port: Int,
	val database: String,
	val username: String,
	val password: String,
)

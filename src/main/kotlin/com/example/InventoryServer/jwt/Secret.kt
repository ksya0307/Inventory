package com.example.InventoryServer.jwt

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.crypto.SecretKey


@Configuration
class Secret @Autowired constructor(private val jwtConfig: JwtConfig) {

    @Bean
    fun secretKey(): SecretKey {
        return Keys.hmacShaKeyFor(jwtConfig.secret!!.toByteArray())
    }

    fun generateKey(): String {
        val secret = Keys.secretKeyFor(SignatureAlgorithm.HS512)
        return secret.encoded.toString()
    }
}

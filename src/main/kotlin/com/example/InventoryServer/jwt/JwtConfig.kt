package com.example.InventoryServer.jwt

import com.google.common.net.HttpHeaders
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
class JwtConfig {
    var secret: String? = null
    var prefix: String? = null
    var weeks: Int? = null
    val authHeader: String
        get() = HttpHeaders.AUTHORIZATION
}

package com.example.InventoryServer.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.time.LocalDate
import java.util.*
import javax.crypto.SecretKey
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthFilter(var authManager: AuthenticationManager, var jwtConfig: JwtConfig, var secretKey: SecretKey): UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val authRequest = ObjectMapper().readValue(request.inputStream, AuthRequest::class.java)
        val auth: Authentication = UsernamePasswordAuthenticationToken(
            authRequest.username, authRequest.password
        )
        return authManager.authenticate(auth)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {

            val token = Jwts.builder()
                .setSubject(authResult.name)
                .claim("authorities", authResult.authorities)
                .setIssuedAt(Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(jwtConfig.weeks!!.toLong())))
                .signWith(Keys.hmacShaKeyFor(secretKey.encoded))
                .compact()

            response.addHeader(jwtConfig.authHeader, jwtConfig.prefix + token)
    }
}

package com.example.InventoryServer.jwt

import com.google.common.base.Strings
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.lang.IllegalStateException
import java.util.stream.Collectors
import javax.crypto.SecretKey
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtValidator(var secretKey: SecretKey, var jwtConfig: JwtConfig): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        val token = authHeader.replace(jwtConfig.prefix!!, "")

        if (Strings.isNullOrEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

            try {
                val claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)

                val body = claims.body
                val username = body.subject

                val authorities = body["authorities"] as List<Map<String, String>>

                val simpleGrantedAuthorities = authorities.stream()
                    .map { a -> SimpleGrantedAuthority(a["authority"]) }
                    .collect(Collectors.toSet())

                val authReq = UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthorities
                )

                SecurityContextHolder.getContext().authentication = authReq
            } catch (e: JwtException) {
                throw IllegalStateException("Token cannot be trusted $token")
            }
        filterChain.doFilter(request, response)
    }
}

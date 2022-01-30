package com.example.InventoryServer.config

import com.example.InventoryServer.jwt.JwtAuthFilter
import com.example.InventoryServer.jwt.JwtConfig
import com.example.InventoryServer.jwt.JwtValidator
import com.example.InventoryServer.services.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.crypto.SecretKey

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig @Autowired constructor(var userDetailsService: UserDetailsService, var secretKey: SecretKey, var jwtConfig: JwtConfig): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http
            ?.csrf()
            ?.disable()
            ?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()
            ?.addFilter(JwtAuthFilter(authenticationManager(), jwtConfig, secretKey))
            ?.addFilterAfter(JwtValidator(secretKey, jwtConfig), JwtAuthFilter::class.java)
            ?.authorizeRequests()
            ?.antMatchers("/", "index", "/css/*", "/js/*")
            ?.permitAll()
            ?.antMatchers("/api/**")
            ?.hasAuthority("READER")
            ?.anyRequest()
            ?.authenticated()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(daoAuthenticationProvider())
    }

    @Bean
    fun daoAuthenticationProvider(): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setPasswordEncoder(passwordEncoder())
        provider.setUserDetailsService(userDetailsService())
        return provider
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return CustomUserDetailsService()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }

}


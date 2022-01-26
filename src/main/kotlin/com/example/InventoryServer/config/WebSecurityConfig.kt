package com.example.InventoryServer.config

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
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.concurrent.TimeUnit

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    override fun configure(http: HttpSecurity?) {
        http
            ?.csrf()
            ?.disable()
            ?.authorizeRequests()
            ?.antMatchers("/", "index", "/css/*", "/js/*")
            ?.permitAll()
            ?.antMatchers("/api/**")
            ?.hasAuthority("READER")
            ?.anyRequest()
            ?.authenticated()
            ?.and()
            ?.formLogin()
            ?.permitAll()
            ?.and()
            ?.rememberMe()
            ?.tokenValiditySeconds(TimeUnit.DAYS.toSeconds(31).toInt())
            ?.key("lisasecurekey")
            ?.userDetailsService(userDetailsService)
            ?.and()
            ?.logout()
            ?.logoutUrl("/logout")
            ?.clearAuthentication(true)
            ?.invalidateHttpSession(true)
            ?.deleteCookies("JSESSIONID","remember-me")
            ?.logoutSuccessUrl("/login")
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


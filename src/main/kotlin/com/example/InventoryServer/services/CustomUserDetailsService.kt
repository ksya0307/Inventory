package com.example.InventoryServer.services

import com.example.InventoryServer.entities.Role
import com.example.InventoryServer.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService: UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {

        try {
            val user = userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("Пользователь с именем $username не найден")

            return org.springframework.security.core.userdetails.User(
                user.username,
                user.password,
                getAuthorities(user.roles)
            )
        }
        catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun getAuthorities(
     roles: List<Role>
 ): MutableSet<GrantedAuthority> {
     val authorities = mutableSetOf <GrantedAuthority>()
    for (role in roles) {
         authorities.add(SimpleGrantedAuthority(role.name))
         role.permissions.stream()
             .map { p -> SimpleGrantedAuthority(p.name) }
             .forEach(authorities::add)
     }
     return authorities
 }
}

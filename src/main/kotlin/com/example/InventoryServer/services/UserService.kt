package com.example.InventoryServer.services

import com.example.InventoryServer.entities.User
import com.example.InventoryServer.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun all():List<User> = userRepository.findAll()
}
package com.example.inventoryServer.services

import com.example.inventoryServer.entities.Users
import com.example.inventoryServer.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun all():List<Users> = userRepository.findAll()
    fun getById(id:Long):Users = userRepository.getById(id.toInt())
}
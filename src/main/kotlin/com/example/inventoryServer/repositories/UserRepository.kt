package com.example.inventoryServer.repositories

import com.example.inventoryServer.entities.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Int> {
}
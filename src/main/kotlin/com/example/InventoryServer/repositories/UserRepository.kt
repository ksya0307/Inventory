package com.example.InventoryServer.repositories;

import com.example.InventoryServer.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
}
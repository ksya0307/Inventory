package com.example.InventoryServer.repositories;

import com.example.InventoryServer.entities.Inventory
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository : JpaRepository<Inventory, Int> {
}
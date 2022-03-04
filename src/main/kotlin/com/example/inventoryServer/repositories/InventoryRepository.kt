package com.example.inventoryServer.repositories

import com.example.inventoryServer.entities.Inventory
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository : JpaRepository<Inventory, Int> {
}
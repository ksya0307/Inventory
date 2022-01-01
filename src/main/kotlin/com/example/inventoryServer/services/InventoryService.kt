package com.example.InventoryServer.services

import com.example.InventoryServer.entities.Inventory
import com.example.InventoryServer.repositories.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(val inventoryRepository: InventoryRepository) {
    fun all():List<Inventory> = inventoryRepository.findAll()
}
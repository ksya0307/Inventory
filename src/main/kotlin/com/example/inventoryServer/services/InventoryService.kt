package com.example.inventoryServer.services

import com.example.inventoryServer.entities.Inventory
import com.example.inventoryServer.repositories.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(val inventoryRepository: InventoryRepository) {
    fun all():List<Inventory> = inventoryRepository.findAll()
    fun inventoryById(id:Int): Inventory = inventoryRepository.findById(id).orElse(null)
    fun addInventory(inventory: Inventory): Inventory = inventoryRepository.save(inventory)
}
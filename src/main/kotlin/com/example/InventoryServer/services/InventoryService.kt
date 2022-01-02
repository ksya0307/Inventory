package com.example.InventoryServer.services

import com.example.InventoryServer.entities.Inventory
import com.example.InventoryServer.repositories.InventoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InventoryService(val inventoryRepository: InventoryRepository) {
    fun all():List<Inventory> = inventoryRepository.findAll()
    fun inventoryById(id:Int): Inventory = inventoryRepository.findById(id).orElse(null)
}
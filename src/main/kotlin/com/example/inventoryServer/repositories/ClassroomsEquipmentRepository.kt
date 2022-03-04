package com.example.inventoryServer.repositories

import com.example.inventoryServer.entities.ClassroomsEquipment
import org.springframework.data.repository.CrudRepository

interface ClassroomsEquipmentRepository : CrudRepository<ClassroomsEquipment, Long> {
}
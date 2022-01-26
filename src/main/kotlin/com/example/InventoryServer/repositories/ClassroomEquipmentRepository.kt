package com.example.InventoryServer.repositories

import com.example.InventoryServer.entities.ClassroomEquipment
import org.springframework.data.repository.CrudRepository

interface ClassroomEquipmentRepository : CrudRepository<ClassroomEquipment, Long> {
}

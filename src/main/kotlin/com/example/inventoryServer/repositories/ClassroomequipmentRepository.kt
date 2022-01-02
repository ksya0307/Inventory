package com.example.InventoryServer.repositories;

import com.example.InventoryServer.entities.Classroomequipment
import org.springframework.data.repository.CrudRepository

interface ClassroomequipmentRepository : CrudRepository<Classroomequipment, Long> {
}
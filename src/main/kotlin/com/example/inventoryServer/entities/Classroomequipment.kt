package com.example.inventoryServer.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "classroomequipment")
open class Classroomequipment {
    @Id
    @Column(name = "inventorynumber", nullable = false)
    open var id: Long? = null
}
package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "equipmentbelonging")
open class Equipmentbelonging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null
}
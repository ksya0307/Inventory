package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "inventory")
open class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null
}
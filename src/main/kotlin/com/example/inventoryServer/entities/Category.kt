package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "category")
open class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null
}
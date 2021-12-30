package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "equipment")
open class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Lob
    @Column(name = "about")
    open var about: String? = null

    @ManyToOne
    @JoinColumn(name = "category")
    open var category: Category? = null
}
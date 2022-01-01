package com.example.InventoryServer.entities

import com.example.InventoryServer.entities.Category
import javax.persistence.*

@Entity
@Table(name = "equipment")
class Equipment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "about")
    var about: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "category")
    var category: Category? = null
)
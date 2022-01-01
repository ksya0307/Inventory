package com.example.InventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "equipmentbelonging")
class Equipmentbelonging (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,
    @Column(name = "name", nullable = false)
    var name:String?=null,

    @OneToMany(mappedBy = "equipmentBelonging", orphanRemoval = true)
    var equipmentBelonging: List<Inventory>

    )
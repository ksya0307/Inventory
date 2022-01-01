package com.example.InventoryServer.entities


import javax.persistence.*

@Entity
@Table(name = "category")
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "name", nullable = false)
    var name:String?=null,

    @OneToMany(orphanRemoval = true, mappedBy = "category")
    var equipment:List<Equipment>? = null

)
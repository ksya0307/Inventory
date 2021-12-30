package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "classrooms")
open class Classroom {
    @Id
    @Lob
    @Column(name = "classnumber", nullable = false)
    open var id: String? = null
}
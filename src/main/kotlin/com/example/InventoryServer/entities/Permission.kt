package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "permissions")
class Permission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int,

    @Column(name = "name")
    var name: String,

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    val roles:List<Role>
)


package com.example.InventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,
    @Column(name = "lastname")
    var lastname: String? = null,
    @Column(name = "firstname")
    var firstname: String? = null,
    @Column(name = "secondname")
    var secondname: String? = null,
    @Column(name = "login")
    var login: String? = null,
    @Column(name = "password")
    var password: String? = null,
    @Column(name = "usertype")
    var usertype: String? = null,
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    var classrooms:List<Classroom>? = null,
    @OneToMany(mappedBy = "responsiblePerson", orphanRemoval = true)
    var responsiblePerson:List<Inventory>? = null,
)
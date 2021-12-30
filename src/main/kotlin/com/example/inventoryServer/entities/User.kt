package com.example.inventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Lob
    @Column(name = "lastname")
    open var lastname: String? = null

    @Lob
    @Column(name = "firstname")
    open var firstname: String? = null

    @Lob
    @Column(name = "secondname")
    open var secondname: String? = null

    @Lob
    @Column(name = "login")
    open var login: String? = null

    @Lob
    @Column(name = "password")
    open var password: String? = null

    @Lob
    @Column(name = "usertype")
    open var usertype: String? = null
}
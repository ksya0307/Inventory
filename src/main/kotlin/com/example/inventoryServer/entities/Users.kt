package com.example.inventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Entity
@Table(name = "users")
class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int?=null

    @Column(name = "surname")
    var surname: String?=null

    @Column(name = "name")
    var name: String?=null

    @Column(name = "patronym")
    var patronym: String?=null

    @Column(name = "username")
    var username: String?=null

    @Column(name = "password")
    var password: String?=null

    @Column(name = "usertype")
    var usertype: String?=null

    @OneToMany(mappedBy = "users",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    var classrooms: List<Classroom>?=null

    @JsonIgnore
    @OneToMany(
        mappedBy = "responsiblePerson",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    var responsiblePerson: List<Inventory>?=null

    @JsonIgnore
    @OneToMany(mappedBy = "users", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var user: List<Classroom>?=null
}
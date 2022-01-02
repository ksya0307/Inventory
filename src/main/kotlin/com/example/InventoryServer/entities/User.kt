package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
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

    @JsonIgnore
    @OneToMany(mappedBy = "responsiblePerson", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var responsiblePerson:List<Inventory>? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var user:List<Classroom>? = null,
)
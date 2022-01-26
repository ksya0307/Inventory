package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "classnumber")
@Entity
@Table(name = "classrooms")
class Classroom (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classnumber", nullable = false)
    var classnumber: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user")
    var user: User?=null,

    @JsonIgnore
    @OneToMany(mappedBy = "classroom", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var classroom:List<ClassroomEquipment>? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "forClassroom", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var forClassroom:List<Inventory>? = null
)

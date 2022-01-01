package com.example.InventoryServer.entities

import javax.persistence.*

@Entity
@Table(name = "classrooms")
class Classroom (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classnumber", nullable = false)
    var classnumber: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user")
    var user: User?=null,

    @OneToMany(mappedBy = "classroom", orphanRemoval = true)
    var classroom:List<Classroomequipment>? = null,

    @OneToMany(mappedBy = "forClassroom", orphanRemoval = true)
    var forClassroom:List<Inventory>? = null
)
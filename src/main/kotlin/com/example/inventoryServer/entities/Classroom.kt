package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "classrooms")
class Classroom (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classnumber", nullable = false)
    var classnumber: String? = null,

    @JsonManagedReference
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user")
    var user: User?=null,

    @OneToMany(mappedBy = "classroom", orphanRemoval = true)
    var classroom:List<Classroomequipment>? = null,

    @OneToMany(mappedBy = "forClassroom", orphanRemoval = true)
    var forClassroom:List<Inventory>? = null
)
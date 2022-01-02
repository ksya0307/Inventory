package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
@Table(name = "classroomequipment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "inventorynumber")
class Classroomequipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventorynumber", nullable = false)
    var inventorynumber: Long? = null,

    @Column(name = "numberinclassroom")
    var numberInClassroom:String?=null,

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "classroom")
    var classroom: Classroom?=null,

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "equipment")
    var equipment: Equipment?=null,

    @JsonIgnore
    @OneToMany(mappedBy = "inventoryNumber", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var inventoryNumber: List<Inventory>?= null
)
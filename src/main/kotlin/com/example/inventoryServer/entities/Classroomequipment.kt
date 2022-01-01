package com.example.InventoryServer.entities


import javax.persistence.*

@Entity
@Table(name = "classroomequipment")
class Classroomequipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventorynumber", nullable = false)
    var id: Long? = null,

    @Column(name = "numberinclassroom")
    var numberInClassroom:String?=null,

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "classroom")
    var classroom: Classroom?=null,

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "equipment")
    var equipment: Equipment?=null,

    @OneToMany(mappedBy = "inventoryNumber", orphanRemoval = true)
    var inventoryNumber: List<Inventory>
)
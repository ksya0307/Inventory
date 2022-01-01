package com.example.InventoryServer.entities


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonManagedReference
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "classroom")
    var classroom: Classroom?=null,

    @JsonManagedReference
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "equipment")
    var equipment: Equipment?=null,

    @OneToMany(mappedBy = "inventoryNumber", orphanRemoval = true)
    var inventoryNumber: List<Inventory>
)
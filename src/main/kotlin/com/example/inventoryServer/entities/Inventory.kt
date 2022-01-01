package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "inventory")
 class Inventory (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "inventorynumber", nullable = false)
    var inventoryNumber: Classroomequipment? = null,

    @Column(name = "getdate", nullable = false)
    var getDate:LocalDate? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "equipmentbelonging")
    var equipmentBelonging:Equipmentbelonging? = null,

    @Column(name = "given", nullable = false)
    var given:String? = null,

    @Column(name = "document", nullable = false)
    var document: String? = null,

    @Column(name = "ifo", nullable = false)
    var ifo: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "forclassroom")
    var forClassroom:Classroom? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "responsibleperson")
    var responsiblePerson:User? = null,

    @Column(name = "comment", nullable = true)
    var comment: String? = null,

    @Column(name = "commentchernega", nullable = true)
    var commentchernega: String? = null
)
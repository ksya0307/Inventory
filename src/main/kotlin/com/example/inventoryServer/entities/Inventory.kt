package com.example.inventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import java.time.LocalDate
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Entity
@Table(name = "inventory")
 class Inventory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   var id: Int?=null

   @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
   @JoinColumn(name = "inventory_number")
   var inventoryNumber: ClassroomsEquipment?=null

   @Column(name = "get_date")
   var getDate: LocalDate?=null

   @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
   @JoinColumn(name = "equipment_belonging")
   var equipmentBelonging: EquipmentBelonging?=null

   @Column(name = "given")
   var given: String?=null

   @Column(name = "document")
   var document: String?=null

   @Column(name = "ifo", nullable = false)
   var ifo: String?=null

   @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
   @JoinColumn(name = "for_classroom")
   var forClassroom: Classroom?=null

   @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
   @JoinColumn(name = "responsible_person")
   var responsiblePerson: Users?=null

   @Column(name = "comment", nullable = true)
   var comment: String?=null

   @Column(name = "comment_chernega", nullable = true)
   var commentchernega: String?=null
}
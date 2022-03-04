package com.example.inventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Entity
@Table(name = "equipment_belonging")
class EquipmentBelonging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int?=null

    @Column(name = "name")
    var name: String?=null

    @JsonIgnore
    @OneToMany(
        mappedBy = "equipmentBelonging",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    var equipmentBelonging: List<Inventory>?=null
}
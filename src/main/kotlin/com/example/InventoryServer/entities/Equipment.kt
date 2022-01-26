package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Entity
@Table(name = "equipment")
class Equipment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(name = "about")
    var about: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "category")
    var category: Category? = null,

    @JsonIgnore
    @OneToMany(orphanRemoval = true, mappedBy = "equipment", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var equipment:List<ClassroomEquipment>? = null
)

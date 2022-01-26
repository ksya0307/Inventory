package com.example.InventoryServer.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Entity
@Table(name = "users",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["username"]) //, "email", "phone"
])
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int,

    @Column(name = "name")
    var name: String,

    @Column(name = "surname")
    var surname: String,

    @Column(name = "patronym")
    var patronym: String,

    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "enabled")
    var enabled: Boolean? = false,

    var passwordMatch: String,

    @JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    var classrooms:List<Classroom>,

    @JsonIgnore
    @OneToMany(mappedBy = "responsiblePerson", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var responsiblePerson:List<Inventory>,

    @JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var user:List<Classroom>,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")], inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
    var roles:List<Role>
)



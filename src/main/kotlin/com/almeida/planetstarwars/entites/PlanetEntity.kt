package com.almeida.planetstarwars.entites

import javax.persistence.*

@Entity
data class PlanetEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val clima: String = "",

    @Column
    @ElementCollection(targetClass = String::class)
    val terrains: List<String> = listOf<String>()
)
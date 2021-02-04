package com.almeida.planetstarwars.repositories

import com.almeida.planetstarwars.entites.PlanetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlanetRepositoryImpl : JpaRepository<PlanetEntity, Long> {
    @Query(value= "SELECT p FROM PlanetEntity p WHERE p.name LIKE :name%")
    fun findByName(@Param("name") name: String) : List<PlanetEntity>
}
package com.almeida.planetstarwars.services

import com.almeida.planetstarwars.entites.PlanetEntity
import com.almeida.planetstarwars.repositories.PlanetRepositoryImpl
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class PlanetServiceImpl(private val repository: PlanetRepositoryImpl) : ServiceInterface<Long, PlanetEntity>
{
    override fun create(e: PlanetEntity) {
        repository.save(e)
    }

    override fun read(id: Long): PlanetEntity? {
        return repository.findById(id).orElse(null)
    }

    override fun update(e: PlanetEntity) {
        this.create(e)
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }

    @Cacheable("planets")
    fun readByName(name: String) : List<PlanetEntity> {
        return repository.findByName(name)
    }
}
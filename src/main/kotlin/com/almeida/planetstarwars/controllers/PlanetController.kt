package com.almeida.planetstarwars.controllers

import com.almeida.planetstarwars.entites.PlanetEntity
import com.almeida.planetstarwars.services.PlanetServiceImpl
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class RequestResponse {}

@RestController
@RequestMapping("/api/planets")
class PlanetController(private val service: PlanetServiceImpl) {

    @GetMapping()
    fun get(@RequestParam(defaultValue = "", required = false) name: String) : ResponseEntity<List<PlanetEntity>> {
        val planets = service.readByName(name)
        return ResponseEntity(
            planets,
            if(planets.isNotEmpty()) HttpStatus.OK else HttpStatus.NOT_FOUND
        )
    }

    @PostMapping
    fun add(@RequestBody model: PlanetEntity) : ResponseEntity<Unit> {
        service.create(model)
        return ResponseEntity(
            Unit,
            HttpStatus.OK
        )
    }
}
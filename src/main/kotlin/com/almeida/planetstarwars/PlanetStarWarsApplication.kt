package com.almeida.planetstarwars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanetStarWarsApplication

fun main(args: Array<String>) {
	runApplication<PlanetStarWarsApplication>(*args)
}

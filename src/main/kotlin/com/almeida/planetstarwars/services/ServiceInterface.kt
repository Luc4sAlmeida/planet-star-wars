package com.almeida.planetstarwars.services

interface ServiceInterface<K, V> {
    fun create(e: V)
    fun read(id: K) : V?
    fun update(e: V)
    fun delete(id: K)
}
package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Personaje

interface RepositorioPersonajes {

    fun poblar() {
        nuevoPersonaje(
            Personaje("Benjamin Sisko", "Capitán de DS9", "Starfleet")
        )
        nuevoPersonaje(
            Personaje("Miles O'Brien", "Jefe ingeniero de DS9", "Starfleet")
        )
        nuevoPersonaje(
            Personaje("Nerys Kira", "Primer Oficial de DS9", "Bajor")
        )
        nuevoPersonaje(
            Personaje("Quark", "Dueño de \"Quark's\"", "Ferengi")
        )
        nuevoPersonaje(
            Personaje("Ezri Dax", "Canciller de DS9", "Starfleet")
        )
        nuevoPersonaje(
            Personaje("Elim Garak", "Sastre", "Bajor")
        )
        nuevoPersonaje(
            Personaje("Gal Dukat", "Gul de la Unión Cardasiana", "Cardassia")
        )
        nuevoPersonaje(
            Personaje("Weyoun", "Vorta del Dominio", "Dominio")
        )
        nuevoPersonaje(
            Personaje("Worf", "Jefe de Seguridad en DS9", "Starfleet")
        )
        nuevoPersonaje(
            Personaje("Alexander Rozhenko", "Oficial de armamento del ya'Vang", "Klingon", "Hijo de Worf")
        )
    }

    fun nuevoPersonaje(p: Personaje)
    fun actualizar(id: Int, p: Personaje)
    fun borrar(id: Int)
    fun buscar(id: Int): Personaje
    fun longitud(): Int

}
package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Bando
import com.example.aplicacionlista.modelo.Personaje

interface RepositorioPersonajes {

    fun poblar() {
        nuevoPersonaje(
            Personaje("Benjamin Sisko", "Capitán de DS9", Bando.STARFLEET)
        )
        nuevoPersonaje(
            Personaje("Miles O'Brien", "Jefe ingeniero de DS9", Bando.STARFLEET)
        )
        nuevoPersonaje(
            Personaje("Nerys Kira", "Primer Oficial de DS9", Bando.BAJOR)
        )
        nuevoPersonaje(
            Personaje("Quark", "Dueño de \"Quark's\"", Bando.FERENGI)
        )
        nuevoPersonaje(
            Personaje("Ezri Dax", "Canciller de DS9", Bando.STARFLEET)
        )
        nuevoPersonaje(
            Personaje("Elim Garak", "Sastre", Bando.BAJOR)
        )
        nuevoPersonaje(
            Personaje("Gul Dukat", "Gul de la Unión Cardasiana", Bando.CARDASSIA)
        )
        nuevoPersonaje(
            Personaje("Weyoun", "Vorta del Dominio", Bando.DOMINION)
        )
        nuevoPersonaje(
            Personaje("Worf", "Jefe de Seguridad en DS9", Bando.STARFLEET)
        )
        nuevoPersonaje(
            Personaje("Alexander Rozhenko", "Oficial de armamento del ya'Vang", Bando.KLINGON, "Hijo de Worf")
        )
    }

    fun nuevoPersonaje(p: Personaje)
    fun actualizar(id: Int, p: Personaje)
    fun borrar(id: Int)
    fun buscar(id: Int): Personaje
    fun longitud(): Int

}
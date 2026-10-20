package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Personaje

class ListaPersonajes : RepositorioPersonajes {
    private val lista: MutableList<Personaje> = mutableListOf()

    override fun nuevoPersonaje(p: Personaje) {
        lista.add(p)
    }

    override fun actualizar(id: Int, p: Personaje) {
        lista[id] = p
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    override fun buscar(id: Int): Personaje = lista[id]

    override fun longitud(): Int {
        return lista.size
    }
}
package com.example.aplicacionlista.datos

class RepositorioSingleton private constructor() {

    companion object {
        val instance = RepositorioSingleton()
    }

    val listaPersonajes: RepositorioPersonajes = ListaPersonajes();

    init {
        listaPersonajes.poblar()
    }

}
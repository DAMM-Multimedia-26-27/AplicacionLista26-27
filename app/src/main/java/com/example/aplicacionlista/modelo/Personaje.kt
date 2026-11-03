package com.example.aplicacionlista.modelo

data class Personaje(
    val nombre: String,
    val ocupacion: String,
    val bando: Bando,
    var descripcion: String = "",
    var opinion: Int = 0
) {

}
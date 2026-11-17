package com.example.aplicacionlista.modelo

data class Personaje(
    var nombre: String,
    var ocupacion: String,
    var bando: Bando,
    var descripcion: String = "",
    var opinion: Int = 0
) {

}
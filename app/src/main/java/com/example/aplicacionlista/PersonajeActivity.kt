package com.example.aplicacionlista

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class PersonajeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idPersonaje = intent.extras?.getInt("numero personaje") ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_personaje)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val personaje = MainActivity.listaPersonajes.buscar(idPersonaje)
        findViewById<TextView>(R.id.textNombre).text = personaje.nombre
        val icono = findViewById<ImageView>(R.id.iconoGrande)
        val draw = AppCompatResources.getDrawable(this, personaje.bando.imagen)
        icono.setImageDrawable(draw)
        val textoOcupacion = findViewById<TextView>(R.id.textOcupacion)
        val textoDescripcion = findViewById<TextView>(R.id.textDescripcion)
        textoOcupacion.text = personaje.ocupacion
        textoDescripcion.text = personaje.descripcion
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = personaje.opinion.toFloat()
    }
}











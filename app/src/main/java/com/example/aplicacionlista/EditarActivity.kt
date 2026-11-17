package com.example.aplicacionlista

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.RepositorioSingleton

class EditarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idPersonaje = intent.extras?.getInt("numero personaje")

        if (idPersonaje != null) {
            val personaje = RepositorioSingleton.instance.listaPersonajes.buscar(idPersonaje)
            val nom = findViewById<EditText>(R.id.editNombre)
            nom.setText(personaje.nombre)
            val ocup = findViewById<EditText>(R.id.editOcupacion)
            ocup.setText(personaje.ocupacion)
            val rating = findViewById<RatingBar>(R.id.editRating)
            rating.rating = personaje.opinion.toFloat()
            val desc = findViewById<EditText>(R.id.editDescripcion)
            desc.setText(personaje.descripcion)

            findViewById<Button>(R.id.bGuardar).setOnClickListener {
                personaje.nombre = nom.text.toString()
                personaje.ocupacion = ocup.text.toString()
                personaje.descripcion = desc.text.toString()
                personaje.opinion = rating.rating.toInt()
                RepositorioSingleton.instance.listaPersonajes.actualizar(idPersonaje, personaje)
                finish()
            }
        } else {

        }
    }
}
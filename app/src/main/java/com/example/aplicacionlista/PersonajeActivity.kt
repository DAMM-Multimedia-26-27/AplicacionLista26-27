package com.example.aplicacionlista

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.RepositorioSingleton
import com.example.aplicacionlista.datos.RepositorioSingletonJ
import org.w3c.dom.Text

class PersonajeActivity : AppCompatActivity() {

    companion object {
        const val NUMERO_PERS = "numero personaje"
    }

    var idPersonaje: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idPersonaje = intent.extras?.getInt(NUMERO_PERS) ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_personaje)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbar_personaje)
        setSupportActionBar(barra)
    }

    override fun onResume() {
        val lista = RepositorioSingleton.instance.listaPersonajes
//        val listaJ = RepositorioSingletonJ.getInstance().getRepo()
        val personaje = lista.buscar(idPersonaje)
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

        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_vista_personaje, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val idBoton = item.itemId
        return when (idBoton) {
            R.id.boton_menu_editar -> {
                val intent = Intent(this, EditarActivity::class.java)
                intent.putExtra(NUMERO_PERS, idPersonaje)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}











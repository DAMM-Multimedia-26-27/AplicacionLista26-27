package com.example.aplicacionlista

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.ListaPersonajes

class MainActivity : AppCompatActivity() {

    companion object {
        val listaPersonajes = ListaPersonajes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        listaPersonajes.poblar()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bIrPersonaje).setOnClickListener {
            dialogoElegir()
        }

        findViewById<Button>(R.id.bLista).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }

    fun dialogoElegir() {
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        entrada.hint = "Número de personaje"
        AlertDialog.Builder(this)
            .setTitle("Elige un personaje")
            .setTitle("Introduce un número para elegir el personaje")
            .setView(entrada)
            .setPositiveButton("Buscar") { dialog, whichButton ->
                val num = entrada.text.toString().toInt()
//                val personajeSeleccionado = listaPersonajes.buscar(num)
//                Log.d("PERSONAJE LOG", personajeSeleccionado.nombre)
                val intent = Intent(this, PersonajeActivity::class.java)
                intent.putExtra("numero personaje", num)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}















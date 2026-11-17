package com.example.aplicacionlista.vista

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionlista.MainActivity
import com.example.aplicacionlista.PersonajeActivity
import com.example.aplicacionlista.R
import com.example.aplicacionlista.datos.RepositorioSingleton

//class AdaptadorLista(private val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {
class AdaptadorLista : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    companion object {
        private var instance: AdaptadorLista? = null

        fun getInstance() : AdaptadorLista {
            if (instance != null){
                return instance!!
            } else {
                instance = AdaptadorLista()
                return instance!!
            }
        }
    }
    val lista = RepositorioSingleton.instance.listaPersonajes

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val contexto = parent.context
        val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflador.inflate(R.layout.tarjeta_personaje, parent, false)
        return CreadorItems(vista, parent.context)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val personaje = lista.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre)
            .text = personaje.nombre
        holder.itemView.findViewById<TextView>(R.id.tarjeta_ocupacion)
            .text = personaje.ocupacion
        holder.itemView.findViewById<TextView>(R.id.tarjeta_descripcion)
            .text = personaje.descripcion
        val draw = AppCompatResources.getDrawable(holder.contexto, personaje.bando.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno)
            .setImageDrawable(draw)
    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }

    class CreadorItems(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView) {
        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val position = bindingAdapterPosition
                val intent = Intent(contexto, PersonajeActivity::class.java)
                intent.putExtra(PersonajeActivity.NUMERO_PERS, position)
                contexto.startActivity(intent)
            }
        }
    }
}















package com.example.smartlearnapp.view.ui.activities
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlearnapp.R

class Recyclerview(var lista: MutableList<Cursos>): RecyclerView.Adapter<Recyclerview.MiHolder>() {

    inner class MiHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var nombres:TextView
        lateinit var descripciones:TextView
        lateinit var precios:TextView
        lateinit var imagenes:ImageView
        init{
            nombres=itemView.findViewById(R.id.name)
            descripciones=itemView.findViewById(R.id.description)
            precios=itemView.findViewById(R.id.price)
            imagenes=itemView.findViewById(R.id.foto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        var itemview = LayoutInflater.from(parent.context).inflate(R.layout.card_cursos,parent, false)
        return MiHolder(itemview)
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        var curso = lista[position]
        holder.nombres.text=curso.nombre
        holder.descripciones.text=curso.descripcion
        holder.precios.text=curso.precio
        holder.imagenes.setImageResource(curso.foto)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}
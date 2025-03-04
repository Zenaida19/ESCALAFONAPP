package com.example.escalafon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DocentesAdapter(
    private val listaDocentes: List<Docente>,
    private val onItemClick: (Docente) -> Unit
) : RecyclerView.Adapter<DocentesAdapter.DocenteViewHolder>() {

    class DocenteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNombre: TextView = view.findViewById(R.id.txtNombreDocente)
        val txtDNI: TextView = view.findViewById(R.id.txtDNIDocente)

        fun bind(docente: Docente, onItemClick: (Docente) -> Unit) {
            txtNombre.text = "${docente.nombres} ${docente.apellidoPaterno} ${docente.apellidoMaterno}"
            txtDNI.text = "DNI: ${docente.dni}"
            itemView.setOnClickListener { onItemClick(docente) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocenteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_docente, parent, false)
        return DocenteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DocenteViewHolder, position: Int) {
        holder.bind(listaDocentes[position], onItemClick)
    }

    override fun getItemCount(): Int = listaDocentes.size
}

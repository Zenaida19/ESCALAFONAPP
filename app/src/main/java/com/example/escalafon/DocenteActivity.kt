package com.example.escalafon
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class DocenteActivity {

    class DocentesActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_docentes)

            val textViewTitulo = findViewById<TextView>(R.id.textViewTitulo)

            // Recibir el tipo de docente desde la pantalla anterior
            val tipo = intent.getStringExtra("tipo")

            if (tipo == "fallecidos") {
                textViewTitulo.text = "Docentes Fallecidos"
            } else if (tipo == "pensionistas") {
                textViewTitulo.text = "Docentes Pensionistas"
            }
        }
    }

}
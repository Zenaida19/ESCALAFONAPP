package com.example.escalafon

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymenu)

        val iconFallecidos = findViewById<ImageView>(R.id.Fallecido)
        val iconPensionistas = findViewById<ImageView>(R.id.Pensionistas)

        // Cuando presione el icono "Docentes Fallecidos"
        iconFallecidos.setOnClickListener {
            val intent = Intent(this, DocentesFallecidosActivity::class.java)
            startActivity(intent)
        }

        // Cuando presione el icono "Docentes Pensionistas"
        iconPensionistas.setOnClickListener {
            val intent = Intent(this, DocentesPensionistasActivity::class.java)
            startActivity(intent)
        }
    }
}

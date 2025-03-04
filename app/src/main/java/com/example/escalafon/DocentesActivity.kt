package com.example.escalafon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DocentesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docentes)

        val btnFallecidos = findViewById<Button>(R.id.btnFallecidos)
        val btnPensionistas = findViewById<Button>(R.id.btnPensionistas)
        val btnAgregar = findViewById<ImageView>(R.id.btnAgregar)

        btnFallecidos.setOnClickListener {
            val intent = Intent(this, RegistroFallecidosActivity::class.java)
            startActivity(intent)
        }

        btnPensionistas.setOnClickListener {
            val intent = Intent(this, RegistroPensionistasActivity::class.java)
            startActivity(intent)
        }

        btnAgregar.setOnClickListener {
            Toast.makeText(this, "Función para agregar más categorías en desarrollo", Toast.LENGTH_SHORT).show()
        }
    }
}

package com.example.escalafon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymenu)

        val btnFallecidos = findViewById<Button>(R.id.btnFallecidos)
        val btnPensionistas = findViewById<Button>(R.id.btnPensionistas)

        btnFallecidos.setOnClickListener {
            val intent = Intent(this, DocentesActivity::class.java)
            startActivity(intent)
        }

        btnPensionistas.setOnClickListener {
            val intent = Intent(this, DocentesActivity::class.java)
            startActivity(intent)
        }
    }
}

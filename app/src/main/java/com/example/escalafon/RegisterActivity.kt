package com.example.escalafon
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class RegisterActivity : AppCompatActivity() {

        private lateinit var databaseHelper: DatabaseHelper

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)

            // Inicializar la base de datos
            databaseHelper = DatabaseHelper(this)

            // Obtener referencias a los elementos del layout
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
            val btnRegistrar = findViewById<Button>(R.id.buttonRegister)

            btnRegistrar.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val registrado = databaseHelper.registrarUsuario(email, password)
                    if (registrado) {
                        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

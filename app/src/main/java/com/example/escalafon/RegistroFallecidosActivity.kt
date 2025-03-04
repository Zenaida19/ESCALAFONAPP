package com.example.escalafon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroFallecidosActivity : AppCompatActivity() {

    private lateinit var editNombres: EditText
    private lateinit var editApellidoPaterno: EditText
    private lateinit var editApellidoMaterno: EditText
    private lateinit var editFechaNacimiento: EditText
    private lateinit var editLugar: EditText
    private lateinit var editNacionalidad: EditText
    private lateinit var editEstadoCivil: EditText
    private lateinit var editEducacion: EditText
    private lateinit var editDNI: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_fallecidos)

        // Inicializar vistas
        editNombres = findViewById(R.id.editNombres)
        editApellidoPaterno = findViewById(R.id.editApellidoPaterno)
        editApellidoMaterno = findViewById(R.id.editApellidoMaterno)
        editFechaNacimiento = findViewById(R.id.editFechaNacimiento)
        editLugar = findViewById(R.id.editLugar)
        editNacionalidad = findViewById(R.id.editNacionalidad)
        editEstadoCivil = findViewById(R.id.editEstadoCivil)
        editEducacion = findViewById(R.id.editEducacion)
        editDNI = findViewById(R.id.editDNI)
        btnGuardar = findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            guardarRegistro()
        }
    }

    private fun guardarRegistro() {
        val nombres = editNombres.text.toString().trim()
        val apellidoPaterno = editApellidoPaterno.text.toString().trim()
        val apellidoMaterno = editApellidoMaterno.text.toString().trim()
        val fechaNacimiento = editFechaNacimiento.text.toString().trim()
        val lugar = editLugar.text.toString().trim()
        val nacionalidad = editNacionalidad.text.toString().trim()
        val estadoCivil = editEstadoCivil.text.toString().trim()
        val educacion = editEducacion.text.toString().trim()
        val dni = editDNI.text.toString().trim()

        if (nombres.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() ||
            fechaNacimiento.isEmpty() || lugar.isEmpty() || nacionalidad.isEmpty() ||
            estadoCivil.isEmpty() || educacion.isEmpty() || dni.isEmpty()
        ) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Registro guardado correctamente.", Toast.LENGTH_SHORT).show()

        limpiarCampos()// Limpiar los campos después de guardar
    }

    private fun limpiarCampos() {
        editNombres.text.clear()
        editApellidoPaterno.text.clear()
        editApellidoMaterno.text.clear()
        editFechaNacimiento.text.clear()
        editLugar.text.clear()
        editNacionalidad.text.clear()
        editEstadoCivil.text.clear()
        editEducacion.text.clear()
        editDNI.text.clear()
    }
}

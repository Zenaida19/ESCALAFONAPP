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
    private lateinit var editDNI: EditText
    private lateinit var editFechaNacimiento: EditText
    private lateinit var editFechaFallecimiento: EditText
    private lateinit var editNacionalidad: EditText
    private lateinit var editDepartamentoProvincia: EditText
    private lateinit var editEstadoCivil: EditText
    private lateinit var editEducacion: EditText
    private lateinit var editExperienciaLaboral: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnGenerarPDF: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_fallecidos)

        // Inicializar vistas
        editNombres = findViewById(R.id.editNombres)
        editApellidoPaterno = findViewById(R.id.editApellidoPaterno)
        editApellidoMaterno = findViewById(R.id.editApellidoMaterno)
        editDNI = findViewById(R.id.editDNI)
        editFechaNacimiento = findViewById(R.id.editFechaNacimiento)
        editFechaFallecimiento = findViewById(R.id.editFechaFallecimiento)
        editNacionalidad = findViewById(R.id.editNacionalidad)
        editDepartamentoProvincia = findViewById(R.id.editDepartamentoProvincia)
        editEstadoCivil = findViewById(R.id.editEstadoCivil)
        editEducacion = findViewById(R.id.editEducacion)
        editExperienciaLaboral = findViewById(R.id.editExperienciaLaboral)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Recuperar los datos guardados de SharedPreferences
        val sharedPreferences = getSharedPreferences("RegistroFallecido", MODE_PRIVATE)
        editNombres.setText(sharedPreferences.getString("nombres", ""))
        editApellidoPaterno.setText(sharedPreferences.getString("apellidoPaterno", ""))
        editApellidoMaterno.setText(sharedPreferences.getString("apellidoMaterno", ""))
        editDNI.setText(sharedPreferences.getString("dni", ""))
        editFechaNacimiento.setText(sharedPreferences.getString("fechaNacimiento", ""))
        editFechaFallecimiento.setText(sharedPreferences.getString("fechaFallecimiento", ""))
        editNacionalidad.setText(sharedPreferences.getString("nacionalidad", ""))
        editDepartamentoProvincia.setText(sharedPreferences.getString("departamentoProvincia", ""))
        editEstadoCivil.setText(sharedPreferences.getString("estadoCivil", ""))
        editEducacion.setText(sharedPreferences.getString("educacion", ""))
        editExperienciaLaboral.setText(sharedPreferences.getString("experienciaLaboral", ""))

        // Configurar el botón Guardar
        btnGuardar.setOnClickListener {
            guardarRegistro()
        }

        btnGenerarPDF.setOnClickListener {
            generarPDF()
        }
    }

    private fun guardarRegistro() {
        val nombres = editNombres.text.toString().trim()
        val apellidoPaterno = editApellidoPaterno.text.toString().trim()
        val apellidoMaterno = editApellidoMaterno.text.toString().trim()
        val dni = editDNI.text.toString().trim()
        val fechaNacimiento = editFechaNacimiento.text.toString().trim()
        val fechaFallecimiento = editFechaFallecimiento.text.toString().trim()
        val nacionalidad = editNacionalidad.text.toString().trim()
        val departamentoProvincia = editDepartamentoProvincia.text.toString().trim()
        val estadoCivil = editEstadoCivil.text.toString().trim()
        val educacion = editEducacion.text.toString().trim()
        val experienciaLaboral = editExperienciaLaboral.text.toString().trim()

        if (nombres.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() ||
            dni.isEmpty() || fechaNacimiento.isEmpty() || fechaFallecimiento.isEmpty() ||
            nacionalidad.isEmpty() || departamentoProvincia.isEmpty() || estadoCivil.isEmpty() ||
            educacion.isEmpty() || experienciaLaboral.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val sharedPreferences = getSharedPreferences("RegistroFallecido", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("nombres", nombres)
        editor.putString("apellidoPaterno", apellidoPaterno)
        editor.putString("apellidoMaterno", apellidoMaterno)
        editor.putString("dni", dni)
        editor.putString("fechaNacimiento", fechaNacimiento)
        editor.putString("fechaFallecimiento", fechaFallecimiento)
        editor.putString("nacionalidad", nacionalidad)
        editor.putString("departamentoProvincia", departamentoProvincia)
        editor.putString("estadoCivil", estadoCivil)
        editor.putString("educacion", educacion)
        editor.putString("experienciaLaboral", experienciaLaboral)
        editor.apply()

        Toast.makeText(this, "Registro guardado correctamente.", Toast.LENGTH_SHORT).show()
        limpiarCampos()
    }

    private fun limpiarCampos() {
        editNombres.text.clear()
        editApellidoPaterno.text.clear()
        editApellidoMaterno.text.clear()
        editDNI.text.clear()
        editFechaNacimiento.text.clear()
        editFechaFallecimiento.text.clear()
        editNacionalidad.text.clear()
        editDepartamentoProvincia.text.clear()
        editEstadoCivil.text.clear()
        editEducacion.text.clear()
        editExperienciaLaboral.text.clear()
    }

    private fun generarPDF() {

        Toast.makeText(this, "Generando PDF...", Toast.LENGTH_SHORT).show()

    }
}

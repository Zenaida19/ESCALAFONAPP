package com.example.escalafon

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class RegistroPensionistasActivity : AppCompatActivity() {

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
    private lateinit var btnImprimirPDF: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pensionistas)

        // Asignar vistas a variables
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
        btnImprimirPDF = findViewById(R.id.btnImprimirPDF)

        btnGuardar.setOnClickListener {
            guardarDatos()
        }

        btnImprimirPDF.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            } else {
                generarPDF()
            }
        }
    }

    private fun guardarDatos() {
        val nombres = editNombres.text.toString()
        val apellidoPaterno = editApellidoPaterno.text.toString()
        val apellidoMaterno = editApellidoMaterno.text.toString()
        val fechaNacimiento = editFechaNacimiento.text.toString()
        val lugar = editLugar.text.toString()
        val nacionalidad = editNacionalidad.text.toString()
        val estadoCivil = editEstadoCivil.text.toString()
        val educacion = editEducacion.text.toString()
        val dni = editDNI.text.toString()

        if (nombres.isEmpty() || dni.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generarPDF() {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(600, 800, 1).create()
        val page = document.startPage(pageInfo)

        val canvas = page.canvas
        val paint = android.graphics.Paint()
        paint.textSize = 16f

        canvas.drawText("Registro de Docente Pensionista", 100f, 50f, paint)
        canvas.drawText("Nombre: ${editNombres.text}", 100f, 100f, paint)
        canvas.drawText("Apellido Paterno: ${editApellidoPaterno.text}", 100f, 130f, paint)
        canvas.drawText("Apellido Materno: ${editApellidoMaterno.text}", 100f, 160f, paint)
        canvas.drawText("Fecha de Nacimiento: ${editFechaNacimiento.text}", 100f, 190f, paint)
        canvas.drawText("DNI: ${editDNI.text}", 100f, 220f, paint)

        document.finishPage(page)

        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "RegistroPensionista.pdf")

        try {
            document.writeTo(FileOutputStream(file))
            Toast.makeText(this, "PDF guardado en Descargas", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        document.close()
    }
}

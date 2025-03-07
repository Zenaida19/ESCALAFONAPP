package com.example.escalafon
import java.util.Calendar
import android.app.DatePickerDialog
import android.Manifest
import android.content.pm.PackageManager
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
private lateinit var dbHelper: DataBaseHelperRegistro

class RegistroPensionistasActivity : AppCompatActivity() {
    private lateinit var dbHelper: DataBaseHelperRegistro
    private lateinit var editNombres: EditText
    private lateinit var editApellidoPaterno: EditText
    private lateinit var editApellidoMaterno: EditText
    private lateinit var editFechaNacimiento: EditText
    private lateinit var editEdad: EditText
    private lateinit var editLugar: EditText
    private lateinit var editProvincia: EditText
    private lateinit var editDepartamento: EditText
    private lateinit var editDistrito: EditText
    private lateinit var editNacionalidad: EditText
    private lateinit var editEstadoCivil: EditText
    private lateinit var editEducacion: EditText
    private lateinit var editExperienciaLaboral: EditText
    private lateinit var editDNI: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnImprimirPDF: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DocentesAdapter
    private val listaDocentes = mutableListOf<Docente>()

    private fun mostrarDetalles(docente: Docente) {
        Toast.makeText(this, "Seleccionado: ${docente.nombres} ${docente.apellidoPaterno}", Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pensionistas)

        dbHelper = DataBaseHelperRegistro(this)


        editFechaNacimiento = findViewById(R.id.editFechaNacimiento)

        editFechaNacimiento.setOnClickListener {
            val calendario = Calendar.getInstance()
            val año = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val día = calendario.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, añoSeleccionado, mesSeleccionado, díaSeleccionado ->
                val fecha = "$díaSeleccionado/${mesSeleccionado + 1}/$añoSeleccionado"
                editFechaNacimiento.setText(fecha)
            }, año, mes, día)

            datePicker.show()
}


        dbHelper = DataBaseHelperRegistro(this)  // Inicializar la base de datos

        // Asignar vistas a variables
        editNombres = findViewById(R.id.editNombres)
        editApellidoPaterno = findViewById(R.id.editApellidoPaterno)
        editApellidoMaterno = findViewById(R.id.editApellidoMaterno)
        editFechaNacimiento = findViewById(R.id.editFechaNacimiento)
        editEdad = findViewById(R.id.editEdad)
        editLugar = findViewById(R.id.editLugar)
        editProvincia = findViewById(R.id.editProvincia)
        editDepartamento = findViewById(R.id.editDepartamento)
        editDistrito = findViewById(R.id.Distrito)
        editNacionalidad = findViewById(R.id.editNacionalidad)
        editEstadoCivil = findViewById(R.id.editEstadoCivil)
        editEducacion = findViewById(R.id.editEducacion)
        editExperienciaLaboral = findViewById(R.id.editExperienciaLaboral)
        editDNI = findViewById(R.id.editDNI)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnImprimirPDF = findViewById(R.id.btnImprimirPDF)
        recyclerView = findViewById(R.id.recyclerViewDocentes)

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DocentesAdapter(listaDocentes) { docente ->
            mostrarDetalles(docente)

        }
        recyclerView.adapter = adapter

        btnGuardar.setOnClickListener {
            guardarDatos()
        }

        btnImprimirPDF.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.Q) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
                } else {
                    generarPDF()
                }
            } else {
                generarPDF()
            }
        }
    }

    private fun guardarDatos() {
        val docente = Docente(
            nombres = editNombres.text.toString(),
            apellidoPaterno = editApellidoPaterno.text.toString(),
            apellidoMaterno = editApellidoMaterno.text.toString(),
            fechaNacimiento = editFechaNacimiento.text.toString(),
            edad = editEdad.text.toString(),
            lugar = editLugar.text.toString(),
            provincia = editProvincia.text.toString(),
            departamento = editDepartamento.text.toString(),
            distrito = editDistrito.text.toString(),
            nacionalidad = editNacionalidad.text.toString(),
            estadoCivil = editEstadoCivil.text.toString(),
            educacion = editEducacion.text.toString(),
            experienciaLaboral = editExperienciaLaboral.text.toString(),
            dni = editDNI.text.toString()
        )

        if (docente.nombres.isEmpty() || docente.dni.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        } else {
            val isInserted = dbHelper.insertarDocente(docente)
            if (isInserted) {
                listaDocentes.add(docente)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun generarPDF() {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(600, 1000, 1).create()
        val page = document.startPage(pageInfo)

        val canvas = page.canvas
        val paint = android.graphics.Paint()
        paint.textSize = 16f

        canvas.drawText("Registro de Docente Pensionista", 100f, 50f, paint)
        canvas.drawText("Nombre: ${editNombres.text}", 100f, 100f, paint)
        canvas.drawText("DNI: ${editDNI.text}", 100f, 130f, paint)

        document.finishPage(page)

        val file = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "RegistroPensionista.pdf")

        try {
            document.writeTo(FileOutputStream(file))
            Toast.makeText(this, "PDF guardado en Documentos", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        document.close()
    }
}

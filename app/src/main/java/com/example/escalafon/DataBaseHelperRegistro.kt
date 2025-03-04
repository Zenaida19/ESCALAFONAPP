package com.example.escalafon

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelperRegistro(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombres TEXT NOT NULL,
                apellido_paterno TEXT NOT NULL,
                apellido_materno TEXT NOT NULL,
                fecha_nacimiento TEXT NOT NULL,
                edad TEXT NOT NULL,
                lugar TEXT NOT NULL,
                provincia TEXT NOT NULL,
                departamento TEXT NOT NULL,
                distrito TEXT NOT NULL,
                nacionalidad TEXT NOT NULL,
                estado_civil TEXT NOT NULL,
                educacion TEXT NOT NULL,
                experiencia_laboral TEXT NOT NULL,
                dni TEXT NOT NULL UNIQUE
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertarDocente(docente: Docente): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("nombres", docente.nombres)
            put("apellido_paterno", docente.apellidoPaterno)
            put("apellido_materno", docente.apellidoMaterno)
            put("fecha_nacimiento", docente.fechaNacimiento)
            put("edad", docente.edad)
            put("lugar", docente.lugar)
            put("provincia", docente.provincia)
            put("departamento", docente.departamento)
            put("distrito", docente.distrito)
            put("nacionalidad", docente.nacionalidad)
            put("estado_civil", docente.estadoCivil)
            put("educacion", docente.educacion)
            put("experiencia_laboral", docente.experienciaLaboral)
            put("dni", docente.dni)
        }

        val resultado = db.insert(TABLE_NAME, null, values)
        db.close()
        return resultado != -1L
    }

    fun obtenerDocentes(): List<Docente> {
        val listaDocentes = mutableListOf<Docente>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val docente = Docente(
                    nombres = cursor.getString(1),
                    apellidoPaterno = cursor.getString(2),
                    apellidoMaterno = cursor.getString(3),
                    fechaNacimiento = cursor.getString(4),
                    edad = cursor.getString(5),
                    lugar = cursor.getString(6),
                    provincia = cursor.getString(7),
                    departamento = cursor.getString(8),
                    distrito = cursor.getString(9),
                    nacionalidad = cursor.getString(10),
                    estadoCivil = cursor.getString(11),
                    educacion = cursor.getString(12),
                    experienciaLaboral = cursor.getString(13),
                    dni = cursor.getString(14)
                )
                listaDocentes.add(docente)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaDocentes
    }

    companion object {
        private const val DATABASE_NAME = "escalafon.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "docentes_pensionistas"
    }
}

package com.example.escalafon
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UsuariosDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    fun registrarUsuario(email: String, password: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("email", email)
        values.put("password", password)
        val result = db.insert("usuarios", null, values)
        return result != -1L
    }
}



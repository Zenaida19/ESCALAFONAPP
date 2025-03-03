import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "usuariosDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val crearTabla = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT UNIQUE, password TEXT)"
        db.execSQL(crearTabla)

        val cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='usuarios'", null)
        if (cursor.count == 0) {
            Log.e("DatabaseHelper", "⚠️ La tabla 'usuarios' NO existe")
        } else {
            Log.d("DatabaseHelper", "✅ La tabla 'usuarios' existe")
        }
        cursor.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    fun registrarUsuario(User: String, password: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("Usuario", User)
        values.put("password", password)

        val resultado = db.insert("usuarios", null, values)
        db.close()

        return resultado != -1L
    }
}

import android.os.Bundle
import android.util.Log // 👀 Importar para ver registros en Logcat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.escalafon.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        databaseHelper = DatabaseHelper(this)

        val editTextUsuario = findViewById<EditText>(R.id.Usuario011)
        val editTextPassword = findViewById<EditText>(R.id.contra123)
        val btnRegistrar = findViewById<Button>(R.id.registrar01)

        btnRegistrar.setOnClickListener {
            Log.d("RegisterActivity", "Botón Registrar presionado") // 🔹 Verifica si el botón responde

            val email = editTextUsuario.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val registrado = databaseHelper.registrarUsuario(email, password)
                if (registrado) {
                    Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                    Log.d("RegisterActivity", "Registro exitoso: $email") // ✅ Verificar en Logcat
                } else {
                    Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                    Log.e("RegisterActivity", "Error en el registro") // ⚠️ Verificar en Logcat
                }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                Log.w("RegisterActivity", "Campos vacíos") // ⚠️ Verificar en Logcat
            }
        }
    }
}

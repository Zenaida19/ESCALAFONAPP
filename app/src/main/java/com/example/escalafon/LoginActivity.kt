
    package com.example.escalafon

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity

    class LoginActivity : AppCompatActivity() {

        // Definir usuario y contraseña fijos
        private val usuarioCorrecto = "admin"
        private val passwordCorrecto = "12345"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            val usuarioEditText = findViewById<EditText>(R.id.Usuario02)
            val passwordEditText = findViewById<EditText>(R.id.Password01)
            val loginButton = findViewById<Button>(R.id.Login01)

            loginButton.setOnClickListener {
                val Usuario = usuarioEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (Usuario == usuarioCorrecto && password == passwordCorrecto) {

                    // ✅ Inicio de sesión exitoso
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish() // Cierra la pantalla de login
                } else {
                    // ❌ Usuario o contraseña incorrectos
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
    }


}
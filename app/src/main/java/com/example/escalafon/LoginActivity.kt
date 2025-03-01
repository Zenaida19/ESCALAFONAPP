
    package com.example.escalafon

    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity

    class LoginActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            val usuarioEditText = findViewById<EditText>(R.id.Usuario02)
            val passwordEditText = findViewById<EditText>(R.id.Password01)
            val loginButton = findViewById<Button>(R.id.Login01)

            loginButton.setOnClickListener {
                val Usuario = usuarioEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (Usuario == "admin@example.com" && password == "123456") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Evita que el usuario regrese a la pantalla de login
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
    }


}
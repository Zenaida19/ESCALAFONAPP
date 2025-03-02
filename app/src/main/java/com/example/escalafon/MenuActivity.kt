import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val iconFallecidos = findViewById<ImageView>(R.id.iconDocentesFallecidos)
        val iconPensionistas = findViewById<ImageView>(R.id.iconDocentesPensionistas)

        // Cuando presione el icono "Docentes Fallecidos"
        iconFallecidos.setOnClickListener {
            val intent = Intent(this, DocentesFallecidosActivity::class.java)
            startActivity(intent)
        }

        // Cuando presione el icono "Docentes Pensionistas"
        iconPensionistas.setOnClickListener {
            val intent = Intent(this, DocentesPensionistasActivity::class.java)
            startActivity(intent)
        }
    }
}

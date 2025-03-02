import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DocentesPensionistasActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var nacimientoEditText: EditText
    private lateinit var agregarButton: Button
    private lateinit var listaDocentes: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docentes_pensionistas)

        // Inicializar vistas
        nombreEditText = findViewById(R.id.editNombre)
        nacimientoEditText = findViewById(R.id.editNacimiento)
        agregarButton = findViewById(R.id.buttonAgregar)
        listaDocentes = findViewById(R.id.listaDocentes)

        // Aquí se agregaría la lógica para guardar y listar datos
    }
}

package com.lab04.visitadoresmedicos

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.lab04.visitadoresmedicos.Model.Paciente

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irAVisita(view: View) {
        val i = Intent(this, VisitActivity::class.java)
        i.putExtra("DNI", Almacen.paciente?.dni ?: "")
        startActivity(i)
    }

    private val irAActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        val intent = result.data ?: return@registerForActivityResult
        // Recuperar datos de la actividad Paciente
        if (result.resultCode == Activity.RESULT_OK) {
            val dni = intent.getStringExtra("Dni")!!
            val apellidos = intent.getStringExtra("Apellidos")!!
            val nombre = intent.getStringExtra("Nombre")!!
            val direccion = intent.getStringExtra("Direccion")!!
            val correo = intent.getStringExtra("Correo")!!

            // Mostrar en el menú principal
            val textView = findViewById<TextView>(R.id.datosPaciente)
            textView.text = "Datos del paciente:\nDni: $dni\nApellidos: $apellidos\n" +
                    "Nombres: $nombre\nDireccion: $direccion\nCorreo: $correo"

            val paciente = Paciente(dni, apellidos, nombre, direccion, correo)
            Almacen.paciente = paciente
            Log.d("MAIN", "Paciente registrado: $paciente")
        }
    }

    fun irARegistrarPaciente(view: View) {
        val intent = Intent(this, PacienteActivity::class.java)
        irAActivity.launch(intent)
    }

    fun enviarCorreoAPaciente(view: View) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(Almacen.paciente?.correo))
            putExtra(Intent.EXTRA_SUBJECT, "Registro de visita")
            val paciente = Almacen.paciente!!
            var informacion = """
                Datos del paciente:
                Dni: ${paciente.dni}
                Apellidos: ${paciente.apellidos}
                Nombres: ${paciente.nombres}
                Dirección: ${paciente.direccion}
                Correo: ${paciente.correo}
                
                Visitas:
            """.trimIndent()
            for (visita in Almacen.visitas) {
                informacion += "\n${visita}"
            }
            putExtra(Intent.EXTRA_TEXT, informacion)
        }
        startActivity(intent)
    }

}

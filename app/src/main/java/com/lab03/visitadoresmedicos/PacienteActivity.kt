package com.lab03.visitadoresmedicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class PacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)
    }

    private fun recuperarTexto(id: Int): String = findViewById<EditText>(id).text.toString()

    fun registrarPaciente(view: View) {
        // Devolver datos a MainActivity
        val returnIntent = Intent()
        returnIntent.putExtra("Dni", recuperarTexto(R.id.editTextDni))
        returnIntent.putExtra("Apellidos", recuperarTexto(R.id.editTextApellidos))
        returnIntent.putExtra("Nombre", recuperarTexto(R.id.editTextNombre))
        returnIntent.putExtra("Direccion", recuperarTexto(R.id.editTextDireccion))
        returnIntent.putExtra("Correo", recuperarTexto(R.id.editTextCorreo))
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

}

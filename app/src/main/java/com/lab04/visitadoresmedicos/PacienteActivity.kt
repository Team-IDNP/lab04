package com.lab04.visitadoresmedicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.BindingAdapter

import com.lab04.visitadoresmedicos.databinding.ActivityPacienteBinding

open class PacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        // val activityMainBinding = DataBindingUtil.setContentView<ActivityPacienteBinding>(this, R.layout.activity_paciente)
        // TODO: todo esto se coloca luego de establecer las variables en el layout
        // activityMainBinding.setViewModel()
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

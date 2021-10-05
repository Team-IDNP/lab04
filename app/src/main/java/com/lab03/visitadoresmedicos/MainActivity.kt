package com.lab03.visitadoresmedicos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts

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

    private val irAActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val intent = result.data ?: return@registerForActivityResult
        // Recuperar datos de la actividad Paciente
        if (result.resultCode == Activity.RESULT_OK) {
            val dni = intent.getStringExtra("Dni")!!
            val apellidos = intent.getStringExtra("Apellidos")!!
            val nombre = intent.getStringExtra("Nombre")!!
            val direccion = intent.getStringExtra("Direccion")!!
            val correo = intent.getStringExtra("Correo")!!

            val paciente = Paciente(dni, apellidos, nombre, direccion, correo)
            Almacen.paciente = paciente
            Log.d("MAIN", "Paciente registrado: $paciente")
        }
    }

    fun irARegistrarPaciente(view: View) {
        val intent = Intent(this, PacienteActivity::class.java)
        irAActivity.launch(intent)
    }

}

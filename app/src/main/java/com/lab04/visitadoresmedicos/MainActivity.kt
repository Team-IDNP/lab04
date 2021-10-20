package com.lab04.visitadoresmedicos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.lab04.visitadoresmedicos.model.Paciente
import com.lab04.visitadoresmedicos.databinding.ActivityMainBinding
import com.lab04.visitadoresmedicos.viewmodel.MainViewModel

open class MainActivity : AppCompatActivity() {

    private val irAActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = MainViewModel(this, irAActivity)
        activityMainBinding.executePendingBindings()
    }

}

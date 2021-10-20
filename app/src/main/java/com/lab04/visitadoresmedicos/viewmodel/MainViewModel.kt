package com.lab04.visitadoresmedicos.viewmodel

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.Almacen
import com.lab04.visitadoresmedicos.model.MainModel
import com.lab04.visitadoresmedicos.PacienteActivity
import com.lab04.visitadoresmedicos.VisitActivity

open class MainViewModel(
    private val context: Context,
    private val activityResultLauncher: ActivityResultLauncher<Intent>
) : BaseObservable() {

    private val mainModel = MainModel("")

    @Bindable
    fun getDatos() = mainModel.getDatosPaciente()

    fun setDatos(datos: String) {
        mainModel.setDatosPaciente(datos)
    }

    fun irAVisita() {
        val i = Intent(context, VisitActivity::class.java)
        i.putExtra("DNI", Almacen.paciente?.getDni() ?: "")
        context.startActivity(i)
    }

    fun irARegistrarPaciente() {
        val intent = Intent(context, PacienteActivity::class.java)
        activityResultLauncher.launch(intent)
    }

    fun enviarCorreoAPaciente() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(Almacen.paciente?.getCorreo()))
            putExtra(Intent.EXTRA_SUBJECT, "Registro de visita")
            val paciente = Almacen.paciente!!
            var informacion = """
                Datos del paciente:
                Dni: ${paciente.getDni()}
                Apellidos: ${paciente.getApellidos()}
                Nombres: ${paciente.getNombres()}
                Dirección: ${paciente.getDireccion()}
                Correo: ${paciente.getCorreo()}
                
                Visitas:
            """.trimIndent()
            for (visita in Almacen.visitas) {
                informacion += "\n${visita}"
            }
            putExtra(Intent.EXTRA_TEXT, informacion)
        }
        context.startActivity(intent)
    }

}
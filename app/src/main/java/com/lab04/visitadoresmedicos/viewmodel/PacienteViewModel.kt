package com.lab04.visitadoresmedicos.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.model.Paciente
import com.lab04.visitadoresmedicos.BR

open class PacienteViewModel(private val activity: Activity) : BaseObservable() {

    private val paciente = Paciente()

    @Bindable
    fun getDni() = paciente.getDni()
    fun setDni(dni: String) {
        paciente.setDni(dni)
        notifyPropertyChanged(BR.dni)
    }

    @Bindable
    fun getApellidos() = paciente.getApellidos()
    fun setApellidos(apellidos: String) {
        paciente.setApellidos(apellidos)
        notifyPropertyChanged(BR.apellidos)
    }

    @Bindable
    fun getNombres() = paciente.getNombres()
    fun setNombres(nombres: String) {
        paciente.setNombres(nombres)
        notifyPropertyChanged(BR.nombres)
    }

    @Bindable
    fun getDireccion() = paciente.getDireccion()
    fun setDireccion(direccion: String) {
        paciente.setDireccion(direccion)
        notifyPropertyChanged(BR.direccion)
    }

    @Bindable
    fun getCorreo() = paciente.getCorreo()
    fun setCorreo(correo: String) {
        paciente.setCorreo(correo)
        notifyPropertyChanged(BR.correo)
    }

    fun registrarPaciente() {
        val returnIntent = Intent()
        returnIntent.putExtra("Dni", getDni())
        returnIntent.putExtra("Apellidos", getApellidos())
        returnIntent.putExtra("Nombre", getNombres())
        returnIntent.putExtra("Direccion", getDireccion())
        returnIntent.putExtra("Correo", getCorreo())
        activity.setResult(Activity.RESULT_OK, returnIntent)
        activity.finish()
    }

}
package com.lab04.visitadoresmedicos.ViewModel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.Model.Paciente

class PacienteViewModel(private val paciente: Paciente) : BaseObservable() {

    @Bindable
    fun getDni() = paciente.getDni()

    @Bindable
    fun getApellidos() = paciente.getApellidos()

    @Bindable
    fun getNombres() = paciente.getNombres()

    @Bindable
    fun getDireccion() = paciente.getDireccion()

    @Bindable
    fun getCorreo() = paciente.getCorreo()

}
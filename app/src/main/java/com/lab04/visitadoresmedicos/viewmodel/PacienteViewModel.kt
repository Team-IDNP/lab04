package com.lab04.visitadoresmedicos.viewmodel

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.model.Paciente

open class PacienteViewModel(private val context: Context) : BaseObservable() {

    private val paciente = Paciente()

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
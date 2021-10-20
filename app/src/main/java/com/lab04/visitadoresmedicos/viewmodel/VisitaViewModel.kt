package com.lab04.visitadoresmedicos.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.model.Visita

open class VisitaViewModel(private val visita: Visita) : BaseObservable() {

    @Bindable
    fun getDni() = visita.getDni()

    @Bindable
    fun getPresion() = visita.getPresion()

    @Bindable
    fun getTemperatura() = visita.getTemperatura()

    @Bindable
    fun getSaturacion() = visita.getSaturacion()

}
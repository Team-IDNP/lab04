package com.lab04.visitadoresmedicos.ViewModel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.Model.Visita

class VisitaViewModel(private val visita: Visita) : BaseObservable() {

    @Bindable
    fun getDni() = visita.getDni()

    @Bindable
    fun getPresion() = visita.getPresion()

    @Bindable
    fun getTemperatura() = visita.getTemperatura()

    @Bindable
    fun getSaturacion() = visita.getSaturacion()

}
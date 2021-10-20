package com.lab04.visitadoresmedicos.viewmodel

import android.app.Activity
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.lab04.visitadoresmedicos.Almacen
import com.lab04.visitadoresmedicos.model.Visita
import com.lab04.visitadoresmedicos.BR

open class VisitaViewModel(
    private val activity: Activity,
    dni: String
) : BaseObservable() {

    private val visita = Visita()

    init {
        setDni(dni)
    }

    @Bindable
    fun getDni() = visita.getDni()
    fun setDni(dni: String) {
        visita.setDni(dni)
        notifyPropertyChanged(BR.dni)
    }

    @Bindable
    fun getPresion() = visita.getPresion().toString()
    fun setPresion(presion: String) {
        visita.setPresion(presion.toDouble())
        notifyPropertyChanged(BR.presion)
    }

    @Bindable
    fun getTemperatura() = visita.getTemperatura().toString()
    fun setTemperatura(temperatura: String) {
        visita.setTemperatura(temperatura.toDouble())
        notifyPropertyChanged(BR.temperatura)
    }

    @Bindable
    fun getSaturacion() = visita.getSaturacion().toString()
    fun setSaturacion(saturacion: String) {
        visita.setSaturacion(saturacion.toDouble())
        notifyPropertyChanged(BR.saturacion)
    }

    fun registrarDatos() {
        val nuevaVisita = Visita(
            dni = visita.getDni(),
            presion = visita.getPresion(),
            temperatura = visita.getTemperatura(),
            saturacion = visita.getSaturacion(),
        )
        Almacen.visitas.add(nuevaVisita)

        Log.d("VISIT_ACTIVITY", "Pacientes registrados:")
        for (v in Almacen.visitas) {
            Log.d("VISIT_ACTIVITY", v.toString())
        }

        // Regresar a activity Principal
        activity.finish()
    }

}
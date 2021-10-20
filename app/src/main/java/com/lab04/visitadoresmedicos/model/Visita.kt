package com.lab04.visitadoresmedicos.model

class Visita(
    private var dni: String = "",
    private var presion: Double = 0.0,
    private var temperatura: Double = 0.0,
    private var saturacion: Double = 0.0,
) {

    fun getDni() = dni
    fun getPresion() = presion
    fun getTemperatura() = temperatura
    fun getSaturacion() = saturacion

    fun setDni(dni: String) {
        this.dni = dni
    }

    fun setPresion(presion: Double) {
        this.presion = presion
    }

    fun setTemperatura(temperatura: Double) {
        this.temperatura = temperatura
    }

    fun setSaturacion(saturacion: Double) {
        this.saturacion = saturacion
    }

}

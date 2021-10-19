package com.lab04.visitadoresmedicos.Model

class Visita(
    private var dni: String,
    private var presion: Double,
    private var temperatura: Double,
    private var saturacion: Double,
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

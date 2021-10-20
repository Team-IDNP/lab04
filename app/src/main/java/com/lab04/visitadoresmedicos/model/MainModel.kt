package com.lab04.visitadoresmedicos.model

open class MainModel(private var datosPaciente: String) {
    fun getDatosPaciente() = datosPaciente

    fun setDatosPaciente(datosPaciente: String) {
        this.datosPaciente = datosPaciente
    }

}
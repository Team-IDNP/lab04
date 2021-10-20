package com.lab04.visitadoresmedicos.model

data class Paciente(
    private var dni: String = "",
    private var apellidos: String = "",
    private var nombres: String = "",
    private var direccion: String = "",
    private var correo: String = "",
) {

    fun getDni(): String = dni
    fun getApellidos(): String = apellidos
    fun getNombres(): String = nombres
    fun getDireccion(): String = direccion
    fun getCorreo(): String = correo

    fun setDni(dni: String) {
        this.dni = dni
    }

    fun setApellidos(apellidos: String) {
        this.apellidos = apellidos
    }

    fun setNombres(nombres: String) {
        this.nombres = nombres
    }

    fun setDireccion(direccion: String) {
        this.direccion = direccion
    }

    fun setCorreo(correo: String) {
        this.correo = correo
    }
}
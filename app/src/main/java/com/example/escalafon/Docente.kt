package com.example.escalafon

data class Docente(
    val nombres: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val fechaNacimiento: String,
    val edad: String,  // Agregado
    val lugar: String,
    val provincia: String,  // Agregado
    val departamento: String,  // Agregado
    val distrito: String,  // Agregado
    val nacionalidad: String,
    val estadoCivil: String,
    val educacion: String,
    val experienciaLaboral: String,  // Agregado
    val dni: String

)

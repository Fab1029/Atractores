package com.example.atractores.Atractor

import java.io.Serializable

data class Atractor(
    val tipo: String,
    val nombre_atractor: String,
    val tamano_atractor: String,
    val atencion_atractor: String,
    val horario_atractor: String

) : Serializable

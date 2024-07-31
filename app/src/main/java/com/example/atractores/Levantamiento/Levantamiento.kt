package com.example.atractores.Levantamiento

import java.io.Serializable
import com.example.atractores.Atractor.Atractor

data class Levantamiento(
    val ID_levantamiento: String,
    val latitud: Float,
    val longitud: Float,
    val modificado: Boolean,
    val subido: Boolean,
    val nombre_calle: String,
    val fecha: String,
    val atractores: HashMap<String, HashMap<String, List<Atractor>>>

): Serializable

package com.example.atractores.Atractor

import java.io.File
import org.json.JSONObject

object Atractores {
    private lateinit var atractores: HashMap<String, List<String>>
    private lateinit var informacion: HashMap<String, List<String>>

    fun parseJSON(filePath: String) {
        // Leer el contenido del archivo JSON
        val jsonString = File(filePath).readText()

        // Parsear el JSON
        val jsonObject = JSONObject(jsonString)

        // Crear el HashMap de atractores
        val atractoresObj = jsonObject.getJSONObject("Atractores")
        atractores = HashMap()
        atractoresObj.keys().forEach { tipo ->
            val lista = atractoresObj.getJSONArray(tipo).let { array ->
                List(array.length()) { index -> array.getString(index) }
            }
            atractores[tipo] = lista
        }

        // Crear el HashMap de información
        val infoObj = jsonObject.getJSONObject("Informacion")
        informacion = HashMap()
        infoObj.keys().forEach { tipoInfo ->
            val lista = infoObj.getJSONArray(tipoInfo).let { array ->
                List(array.length()) { index -> array.getString(index) }
            }
            informacion[tipoInfo] = lista
        }
    }

    fun obtenerTiposAtractores(): Set<String> = atractores.keys


    fun obtenerAtractoresDeTipo(tipo: String): List<String>?  = atractores[tipo]


    fun obtenerTiposInformacion(): Set<String>  = informacion.keys


    fun obtenerInformacionDeTipo(tipoInfo: String): List<String>?  = informacion[tipoInfo]

}



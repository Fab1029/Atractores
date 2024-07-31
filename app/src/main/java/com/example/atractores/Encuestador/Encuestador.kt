package com.example.atractores.Encuestador

import android.content.Context
import com.example.atractores.Levantamiento.Levantamiento
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.TreeMap

object Encuestador {
    val ID: String = "Fabian"
    var levantamientos: TreeMap<String, Levantamiento> = TreeMap()
    private const val FILE_NAME = "com/example/atractores/Data/encuestadorData.dat"




    fun cargar_encuestador(context: Context) {
        try {
            val fileInputStream = context.openFileInput(FILE_NAME)
            val objectInputStream = ObjectInputStream(fileInputStream)

            val obj = objectInputStream.readObject()
            if (obj is TreeMap<*, *>) {
                @Suppress("UNCHECKED_CAST")
                levantamientos = obj as TreeMap<String, Levantamiento>
            }

            objectInputStream.close()
            fileInputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun guardar_encuestador(context: Context){
        try {
            val fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            val objectOutputStream = ObjectOutputStream(fileOutputStream)

            objectOutputStream.writeObject(this.levantamientos)
            objectOutputStream.close()
            fileOutputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
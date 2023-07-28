package com.example.roomej1modulo6

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDAO: TareaDAO) {
    suspend fun insertarTask(tarea: Tarea){
        tareaDAO.insertarTarea(tarea) //isertar tarea
    }
    fun getTareas(): LiveData<List<Tarea>>{
        return tareaDAO.getTareas()  //obtener Tareas
    }
}
package com.example.roomej1modulo6

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDAO {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)
}
package com.example.roomej1modulo6

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDAO {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    @Query("select * from tabla_Tarea order by id ASC" )
    fun getTareas(): List<Tarea>
}
package com.example.roomej1modulo6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_Tarea")
data class Tarea(val nombre :String, val fecha:String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

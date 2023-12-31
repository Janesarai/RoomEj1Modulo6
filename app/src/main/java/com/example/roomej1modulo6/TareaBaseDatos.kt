package com.example.roomej1modulo6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea:: class], version = 1)
abstract class TareaBaseDatos: RoomDatabase()  {

        abstract fun getTaskDao(): TareaDAO

        companion object {
            @Volatile
            private var INSTANCE: TareaBaseDatos? = null

            fun getDatabase(context: Context): TareaBaseDatos {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TareaBaseDatos :: class.java,
                        "tarea_Basedatos"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
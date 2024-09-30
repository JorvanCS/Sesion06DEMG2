package com.example.sesion06demg2.logicaNegocios

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class EstudiantesEntidad(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var nombres:String,
    var apellidos:String,
    var dni:String,
    var curso:String,
    var horas:Int
)

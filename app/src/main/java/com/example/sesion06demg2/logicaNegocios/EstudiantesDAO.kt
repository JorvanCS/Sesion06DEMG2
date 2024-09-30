package com.example.sesion06demg2.logicaNegocios

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EstudiantesDAO {

    @Insert
    fun guardar(estudiante:EstudiantesEntidad)

    @Update
    fun actualizar(estudiante:EstudiantesEntidad)

    @Delete
    fun eliminar(estudiante:EstudiantesEntidad)

    @Query("select id,nombres,apellidos,dni,curso,horas" +
            " from estudiantes where id= :idX")
    fun obtenerEstudiante(idX:Int):EstudiantesEntidad

    @Query("select id,nombres,apellidos,dni,curso,horas" +
            " from estudiantes")
    fun obtenerListaEstudiantes():List<EstudiantesEntidad>
}
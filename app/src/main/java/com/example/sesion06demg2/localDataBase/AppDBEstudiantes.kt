package com.example.sesion06demg2.localDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sesion06demg2.logicaNegocios.EstudiantesDAO
import com.example.sesion06demg2.logicaNegocios.EstudiantesEntidad

@Database(entities = [EstudiantesEntidad::class],
    version = 1, exportSchema = false)
abstract class AppDBEstudiantes:RoomDatabase() {
    //Indicar el DAO a utilizar para la entidad[Estudiante]
    abstract fun estudianteDao():EstudiantesDAO
}
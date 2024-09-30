package com.example.sesion06demg2.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.sesion06demg2.componentesUI.BotonGenerico
import com.example.sesion06demg2.componentesUI.ElementosListadoEstudiantes
import com.example.sesion06demg2.localDataBase.AppDBEstudiantes
import com.example.sesion06demg2.logicaNegocios.EstudiantesEntidad

val listaEstudiantes= mutableStateListOf<EstudiantesEntidad>()
@Composable
fun ListadosUI(){
    //definir la base de datos a utilizar
    val contexto= LocalContext.current
    val db= Room.databaseBuilder(contexto, AppDBEstudiantes::class.java,
        "app_dbEstudiantes").allowMainThreadQueries().build()
    val dao=db.estudianteDao()

    Column {
        Text(text = "Listado de Estudiantes")
        BotonGenerico(texto = "Ver Datos",
            icono = Icons.Outlined.Search) {
            listaEstudiantes.clear()
            dao.obtenerListaEstudiantes().forEach { listaEstudiantes.add(it) }
        }
        LazyColumn {
            itemsIndexed(listaEstudiantes){indice,elemento->
                ElementosListadoEstudiantes(estudiante = elemento,
                    indice = indice)
            }
        }
    }
}
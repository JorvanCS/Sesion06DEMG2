package com.example.sesion06demg2.views

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sesion06demg2.componentesUI.BotonGenerico
import com.example.sesion06demg2.componentesUI.CajaTextoGenerica
import com.example.sesion06demg2.localDataBase.AppDBEstudiantes
import com.example.sesion06demg2.logicaNegocios.EstudiantesEntidad

@Composable
fun RegistrosUI(){
    //definir la base de datos a utilizar
    val contexto= LocalContext.current
    val db= Room.databaseBuilder(contexto,AppDBEstudiantes::class.java,
        "app_dbEstudiantes").allowMainThreadQueries().build()
    val dao=db.estudianteDao()
    //variables de estado
    var nombres by remember {mutableStateOf("") }
    var apellidos by remember {mutableStateOf("") }
    var dni by remember {mutableStateOf("") }
    var curso by remember {mutableStateOf("") }
    var horas by remember {mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Registro de Estudiante")
        CajaTextoGenerica(texto = nombres, label = "Nombres") {
            nombres=it
        }
        CajaTextoGenerica(texto = apellidos, label = "Apellidos") {
            apellidos=it
        }
        CajaTextoGenerica(texto = dni, label = "DNI") {
            dni=it
        }
        CajaTextoGenerica(texto = curso, label = "Curso") {
            curso=it
        }
        CajaTextoGenerica(texto = horas, label = "Horas") {
            horas=it
        }
        BotonGenerico(texto = "Guardar", icono = Icons.Outlined.Save) {
            if (nombres.isNotBlank()||apellidos.isNotBlank()
                ||dni.isNotBlank()){
                var estudiante=EstudiantesEntidad(0,nombres,apellidos,
                    dni,curso,horas.toInt())
                    //guardar en la tabla estudiantes
                dao.guardar(estudiante)
                nombres="";apellidos="";dni="";curso=""
                horas=""
            }else{
                Toast.makeText(contexto,"Faltan Datos",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
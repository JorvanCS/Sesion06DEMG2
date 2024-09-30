package com.example.sesion06demg2.componentesUI


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sesion06demg2.logicaNegocios.EstudiantesEntidad
import com.example.sesion06demg2.modeloNav.ItemsBarraInferior
import com.example.sesion06demg2.navegacion.RutaActualNav

//definir elementos de la barra inferior
val menuItems= listOf(ItemsBarraInferior.ItemInicio,
    ItemsBarraInferior.ItemRegistros,ItemsBarraInferior.ItemListados)
@Composable
fun NavegacionInferior(navcontrolador:NavHostController){
    BottomAppBar {
        NavigationBar {
            menuItems.forEach { 
                val rutaActual= RutaActualNav(navcontrolador 
                = navcontrolador)==it.ruta
                NavigationBarItem(selected = rutaActual ,
                    onClick = { navcontrolador.navigate(it.ruta)},
                    icon = { Icon(imageVector = it.icono,
                        contentDescription = null) },
                    label = { Text(text = it.titulo)})
            }
        }
    }
}

@Composable
fun CajaTextoGenerica(texto:String,label:String,
                      onvalue:(String)->Unit){
    OutlinedTextField(value = texto, label = { Text(text = label)},
        onValueChange =onvalue )
}
@Composable
fun BotonGenerico(texto:String,icono:ImageVector,onclick:()->Unit){
    Button(onClick = onclick) {
        Icon(imageVector = icono, contentDescription = null)
        Text(text = texto)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarra(titulo:String,colorBarra:Color){
    TopAppBar(title = { Text(text = titulo) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorBarra
        )
    )
}
//Boton flotante de accion
@Composable
fun BotonFlotante(onclick:()->Unit){
    FloatingActionButton(onClick = onclick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}

//Estructura del LazyColumn
@Composable
fun ElementosListadoEstudiantes(estudiante:EstudiantesEntidad,indice:Int){
    //definir variable de estado para activar/desactivar el dialogo
    var verDialogo by remember {mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(2.5f)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Nombres: ${estudiante.nombres}")
                    Text(text = "Apellidos: ${estudiante.apellidos}")
                }
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Text(text = "DNI: ${estudiante.dni}")
                    Text(text = "Curso: ${estudiante.curso}")
                }
            }
            Row(modifier = Modifier
                .weight(1f)
                .padding(3.dp),
                horizontalArrangement = Arrangement.End) {
                BotonGenerico(texto = "", icono = Icons.Default.Delete) {
                    //evento click  - activar el dialogo
                    verDialogo=true
                }
            }
        }
    }
    HorizontalDivider(modifier = Modifier.padding(2.dp))
    //invocar al dialogo
    DialogoPersonalizado(visible = verDialogo,
        cancelaAccion = { verDialogo=false}
    ) {
        //Acepta el usuario
        //remover al alumno de la lista previa confirmacion
        //listaAlumnos.removeAt(indice)
        verDialogo=false
    }
}

//Dialogo personalizado
@Composable
fun DialogoPersonalizado(visible:Boolean,cancelaAccion:()->Unit,
                         aceptaAccion:()->Unit){
    if (visible){
        AlertDialog(
            title = { Text(text = "Confirmación")},
            text = { Text(text = "¿Desea eliminar?")},
            onDismissRequest = { cancelaAccion },
            confirmButton = {
                TextButton(onClick = { aceptaAccion()}) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { cancelaAccion()}) {
                    Text(text = "Cancelar", color = Color.Red)
                }
            }
        )
    }
}
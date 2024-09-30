package com.example.sesion06demg2.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sesion06demg2.views.InicioUI
import com.example.sesion06demg2.views.ListadosUI
import com.example.sesion06demg2.views.RegistrosUI

@Composable
fun AppNavegacionInferior(navcontrolador:NavHostController){
    NavHost(navController = navcontrolador,
        startDestination = ElementosNav.Inicio.ruta){
        composable(route = ElementosNav.Inicio.ruta) {
            //Invocar la UI Inicio
            InicioUI()
        }
        composable(route = ElementosNav.Registros.ruta) {
            //Invocar la UI registros
            RegistrosUI()
        }
        composable(route = ElementosNav.Listados.ruta) {
            //Invocar la UI Listados
            ListadosUI()
        }
    }
}
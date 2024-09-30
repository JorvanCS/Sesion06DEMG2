package com.example.sesion06demg2.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.sesion06demg2.componentesUI.NavegacionInferior
import com.example.sesion06demg2.componentesUI.TopBarra
import com.example.sesion06demg2.navegacion.AppNavegacionInferior

@Composable
fun PrincipalUI(){
    val navcontrolador= rememberNavController()
    Scaffold(
        topBar = { TopBarra(titulo = "Manejo ROOM",
            colorBarra = Color(0xFFa8dff6)
        )},
        bottomBar = { NavegacionInferior(
            navcontrolador =navcontrolador )}
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {
            //invocar al manejador Nav
            AppNavegacionInferior(navcontrolador = navcontrolador)
        }
    }
}
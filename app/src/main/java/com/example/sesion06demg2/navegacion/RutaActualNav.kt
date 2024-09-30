package com.example.sesion06demg2.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun RutaActualNav(navcontrolador:NavHostController):String?=
    navcontrolador.currentBackStackEntryAsState()
        .value?.destination?.route
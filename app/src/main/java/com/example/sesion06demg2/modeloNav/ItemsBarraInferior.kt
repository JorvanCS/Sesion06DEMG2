package com.example.sesion06demg2.modeloNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LineWeight
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.sesion06demg2.navegacion.ElementosNav

sealed class ItemsBarraInferior(val icono:ImageVector,
    val titulo:String,val ruta:String) {

    object ItemInicio:ItemsBarraInferior(Icons.Outlined.Home,
        "Inicio",ElementosNav.Inicio.ruta)
    object ItemRegistros:ItemsBarraInferior(Icons.Outlined.AccountCircle,
        "Registros",ElementosNav.Registros.ruta)
    object ItemListados:ItemsBarraInferior(Icons.Outlined.LineWeight,
        "Listados",ElementosNav.Listados.ruta)
}
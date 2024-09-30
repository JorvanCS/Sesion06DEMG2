package com.example.sesion06demg2.navegacion

import com.example.sesion06demg2.modeloNav.RutasNav

sealed class ElementosNav(val ruta:String) {
    object Inicio:ElementosNav(RutasNav.Inicio.name)
    object Registros:ElementosNav(RutasNav.Registros.name)
    object Listados:ElementosNav(RutasNav.Listados.name)
}
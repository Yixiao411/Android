package com.example.myapplication.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey{
    @Serializable
    data object Pantalla1 : Routes()
    @Serializable
    data class Pantalla2(val nombre: String) : Routes() {
    }

    @Serializable
    data class Pantalla3(val salutacio: String, val nombre: String, val edad: Int) : Routes()
}
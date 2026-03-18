package com.example.myapplication.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.Ex6_Pantalla1
import com.example.myapplication.Ex6_Pantalla2
import com.example.myapplication.Ex6_Pantalla3

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.Pantalla1)

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLast()
            }
        },
        entryProvider = entryProvider {

            entry<Routes.Pantalla1> {
                Ex6_Pantalla1 { nombre ->
                    backStack.add(Routes.Pantalla2(nombre))
                }
            }
            entry<Routes.Pantalla2> { key ->
                Ex6_Pantalla2(nombre = key.nombre){ salutacio, nombre, edad ->
                    backStack.add(Routes.Pantalla3(salutacio, nombre, edad))
                }
            }
            entry<Routes.Pantalla3> { key ->
                Ex6_Pantalla3(salutacio = key.salutacio, nombre = key.nombre, edad = key.edad) {
                    while (backStack.size > 1) backStack.removeLast()
                }
            }
        }
    )
}

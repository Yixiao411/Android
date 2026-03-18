package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun Ex6_Pantalla3(salutacio: String, nombre: String, edad: Int, navigateBack: () -> Unit) {
    var showText by remember { mutableStateOf(false) }
    var salut by remember { mutableStateOf(salutacio == "Hola") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (!showText) {
                Button(
                    onClick = {
                        showText = true
                    },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cyanGreen))
                ) {
                    Text("SHOW",
                        modifier = Modifier
                            .padding(10.dp))
                }
            }else{
                if (salut){
                    Text("Hola $nombre, com portes aquests $edad anys?")
                }else{
                    Text("Espero tornar a veure’t $nombre, abans que facis ${edad+1} anys")
                }
            }
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            shape = RectangleShape,
            onClick = {
                    navigateBack()
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cyanGreen))
        ) {
            Text(text = "RETURN")
        }
    }
}
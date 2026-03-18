package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import kotlin.String
import kotlin.Unit
@Composable
fun Ex6_Pantalla2(nombre: String, navigateToScreen3: (String, String, Int) -> Unit) {
    val salutacions = listOf("Hola", "Adeu")
    var salutacio by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                salutacions.forEach { salut ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = salutacio == salut,
                            onClick = {
                                salutacio = salut
                            },
                            colors = RadioButtonDefaults.colors(colorResource(R.color.cyanGreen))
                        )

                        Text(salut,
                            color = colorResource(R.color.cyanGreen))
                    }
                }

                Slider(
                    value = sliderPosition,
                    onValueChange = {
                        sliderPosition = it
                    },
                    valueRange = 10f..80f,
                    modifier = Modifier.fillMaxWidth(0.8f),
                )
                Text(text = "${sliderPosition.toInt()}",
                    fontSize = 36.sp,
                    color = colorResource(R.color.cyanGreen)
                    )
            }
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            shape = RectangleShape,
            onClick = {
                    navigateToScreen3(salutacio, nombre, sliderPosition.toInt())
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cyanGreen))
        ) {
            Text(text = "NEXT STEP")
        }
    }
}
package com.example.myapplication

import android.widget.SeekBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.selects.select
import kotlin.String
import kotlin.Unit

@Composable
fun Ex6_Pantalla2() {
    var salutacions = listOf("Hola", "Adeu")
    var salutacio by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column() {
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

                        Text(salut)
                    }
                }


            }
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            shape = RectangleShape,
            onClick = {
                    //navigateToScreen3(nombre)
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cyanGreen))
        ) {
            Text(text = "NEXT STEP")
        }
    }
}
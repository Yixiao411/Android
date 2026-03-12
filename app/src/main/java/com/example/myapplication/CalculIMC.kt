package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CalculIMC(modifier: Modifier){
    var nombre by remember { mutableStateOf("") }
    var any by remember { mutableStateOf("") }
    var alcada by remember { mutableStateOf("") }
    var pes by remember { mutableStateOf("") }
    var imc by remember { mutableDoubleStateOf(0.0) }
    var estat by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = {
                Text("Nom de usuari")
            }
        )
        TextField(
            value = any,
            onValueChange = { any = it },
            label = { Text("Any de naixement") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        TextField(
            value = alcada,
            onValueChange = { alcada = it },
            label = { Text("Alçada en metre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        TextField(
            value = pes,
            onValueChange = { pes = it },
            label = { Text("Pes") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Spacer(Modifier.padding(20.dp))

        Button(onClick = {
            imc = pes.toDouble()/(alcada.toDouble()*alcada.toDouble())
            when(imc){
                in -1.0..18.5 -> estat = "insuficient"
                in 18.5..25.0 -> estat = "normal"
                else -> estat = "obesitat"
            }
        }) {
            Text("Calcula el imc")
        }

        Text("IMC: ${String.format("%.2f", imc)}")
        Text(estat)
    }
}
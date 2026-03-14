package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun NumeroSecret(modifier: Modifier = Modifier){
    var num by remember { mutableStateOf(Random.nextInt(0, 101)) }
    var adv by remember { mutableStateOf("") }
    var messeg by remember { mutableStateOf("Tente adivinar el número!") }

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("QUIZ", fontWeight = FontWeight.ExtraBold, fontSize = 36.sp)
        
        Text(messeg, modifier = Modifier.padding(16.dp))

        TextField(
            value = adv,
            onValueChange = { adv = it },
            label = { Text("Adivina entre 0 - 100") }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Button( onClick = {
            val userGuess = adv.toIntOrNull()
            if (userGuess == null) {
                messeg = "Por favor, introduce un número válido"
            } else if (userGuess == num) {
                messeg = "¡Correcto! El número era $num"
            } else if (userGuess < num) {
                messeg = "El número es más GRANDE"
            } else {
                messeg = "El número es más PEQUEÑO"
            }
        }){
            Text("Comprovar")
        }

        Button(onClick = {
            num = Random.nextInt(0, 101)
            messeg = "Nuevo número generado. ¡Adivina!"
            adv = ""
        }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Reiniciar Juego")
        }
    }
}

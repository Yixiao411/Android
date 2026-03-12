package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun NumeroSecret(modifier: Modifier){
    var num by remember { mutableStateOf(0) }
    var adv by remember { mutableStateOf("") }
    var messeg by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("QUIZ", fontWeight = FontWeight.ExtraBold, fontSize = 36.sp)
        Button(onClick = {
            num = Random.nextInt(0, 101)
        }) {
            Text("Genera Numero Random")
        }

        TextField(value = adv,
            onValueChange = {
                adv = it
            },
            label = { Text("Adivina entre 0 - 100") }
            )

        Button( onClick = {
            if (adv.toInt() == num){

            }
        }){
            Text("Comprovar")
        }
    }
}
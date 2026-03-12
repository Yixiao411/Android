package com.example.myapplication

import android.inputmethodservice.Keyboard
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculadoraPropina(modifier: Modifier) {
    var preuMenu by remember { mutableStateOf("") }
    var propina by remember { mutableStateOf("") }
    var preuTotal by remember { mutableStateOf(0.0) }
    var showResult by remember { mutableStateOf(false) }
    var enableButton by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = preuMenu,
            onValueChange = {
                preuMenu = it
                enableButton = habilitatBoton(preuMenu,propina) },
            label = { Text("Preu del menu") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        TextField(
            value = propina,
            onValueChange = {
                propina = it
                enableButton = habilitatBoton(preuMenu,propina) },
            label = { Text("Propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

        Spacer(Modifier.height(50.dp))
        Button(onClick = {
            showResult = true
            preuTotal = preuMenu.toDouble() + propina.toDouble()
        }, enabled = enableButton) {
            Text("Calcular preu total")
        }
        Spacer(Modifier.height(50.dp))
        if (showResult){
            Text("Preu Total: $preuTotal", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

fun habilitatBoton(preuMenu: String, propina: String): Boolean{
    var res = false
    if(preuMenu.isNotEmpty() && propina.isNotEmpty()){
        res=true
    }
    return res
}
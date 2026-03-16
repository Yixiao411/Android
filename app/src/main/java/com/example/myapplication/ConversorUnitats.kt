package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversorUnitats(modifier: Modifier) {
    var valor by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Resultat") }
    var operacio by remember { mutableStateOf("Operacio") }
    var hided by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Conversor de unitats",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            modifier = Modifier.fillMaxWidth(0.7f),
            )
        Spacer(Modifier.padding(30.dp))

        TextField(
            value = valor,
            onValueChange = {
                valor = it
            },
            label = { Text("Valor") }
        )

        UnitatsDropDownMenu (operacio){
            operacio = it
        }

        Button(
            onClick = {
                val num = valor.toDoubleOrNull()
                if (num != null) {
                    hided = false
                    result = convertUnit(num, operacio)
                }
            }
        ) {
            Text("Calcular")
        }

        Spacer(Modifier.padding(5.dp))

        if(!hided){
            Text(
                text = result,
                modifier = Modifier.padding(16.dp),
                )
        }
    }
}

@Composable
fun UnitatsDropDownMenu(operacio: String, onValueChange: (String) -> Unit){
    var expanded by remember { mutableStateOf(false) }
    var operacions = listOf(
        "Polzada a Centimetre",
        "Iarda a metre",
        "Milla a quilometre",
        "Centimetre a Polzada",
        "Metre a Iarda",
        "Quilometre a Milla")

    Column(modifier = Modifier.padding((20.dp))){
        OutlinedTextField(
            value = operacio,
            onValueChange = { onValueChange(it) },
            enabled = false,
            readOnly = true,
            label = { Text("Operacio") },
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color.Black
            )
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth()
    ) {
        operacions.forEach { seleccio ->
            DropdownMenuItem(
                text = { Text(text = seleccio) },
                onClick = {
                    expanded = false
                    onValueChange(seleccio)
                }
            )
        }
    }

}


fun convertUnit(valor: Double, operacio: String): String {
    var res = ""

    // Definimos los factores de conversión
    val polzadaAcm = 2.54
    val iardaAMetre = 0.9144
    val millaAKm = 1.60934

    when(operacio) {
        "Polzada a Centimetre" -> {
            val calculo = valor * polzadaAcm
            res = "$valor polzades són ${"%.2f".format(calculo)} cm"
        }
        "Iarda a metre" -> {
            val calculo = valor * iardaAMetre
            res = "$valor iardes són ${"%.2f".format(calculo)} metres"
        }
        "Milla a quilometre" -> {
            val calculo = valor * millaAKm
            res = "$valor milles són ${"%.2f".format(calculo)} km"
        }
        "Centimetre a Polzada" -> {
            val calculo = valor / polzadaAcm
            res = "$valor cm són ${"%.2f".format(calculo)} polzades"
        }
        "Metre a Iarda" -> {
            val calculo = valor / iardaAMetre
            res = "$valor metres són ${"%.2f".format(calculo)} iardes"
        }
        "Quilometre a Milla" -> {
            val calculo = valor / millaAKm
            res = "$valor km són ${"%.2f".format(calculo)} milles"
        }
        else -> res = "Operació no reconeguda"
    }

    return res
}
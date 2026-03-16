package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculadora(modifier: Modifier){
    var op1 by remember { mutableStateOf("") }
    var op2 by remember { mutableStateOf("") }
    var operacio by remember { mutableStateOf("") }
    var result by remember { mutableDoubleStateOf(Double.MIN_VALUE) }
    val context = LocalContext.current
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text("Calculadora", fontWeight = FontWeight.ExtraBold, fontSize = 36.sp)
        Spacer(Modifier.padding(10.dp))
        TextField(value = op1,
            onValueChange = {
                op1 = it
            },
            label = { Text("Número 1") }
        )

        TextField(value = op2,
            onValueChange = {
                op2 = it
            },
            label = { Text("Número 2") }
        )
        Spacer(Modifier.padding(10.dp))
        if(result != Double.MIN_VALUE) {
            Text(
                "Resultat: $result"
            )
        }
        Spacer(Modifier.padding(10.dp))

        MyDropDownMenu(operacio){
            operacio = it
        }

        Button(onClick = {
            val num1 = op1.toDoubleOrNull()
            val num2 = op2.toDoubleOrNull()
            if (num1 == null || num2 == null) {
                Toast.makeText(context, "Por favor, introduce números válidos", Toast.LENGTH_SHORT).show()
            } else if (operacio == "Divisio" && num2 == 0.0) {
                Toast.makeText(context, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
            }else{
                result = calcula(num1,num2,operacio)
            }
        }) {
            Text("Calcular")
        }
    }
}

fun calcula(num1: Double, num2: Double, operacio: String): Double{
    var res = 0.0
    when(operacio){
        "Suma" -> {
            res = num1 + num2
        }
        "Resta" -> {
            res = num1 - num2
        }
        "Multiplica" -> {
            res = num1 * num2
        }
        "Divisio" -> {
            res = num1 / num2
        }
    }
    return res
}


@Composable
fun MyDropDownMenu(operacio: String, onValueChange: (String) -> Unit) {
    //var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val operacions = listOf("Suma", "Resta", "Multiplica", "Divisio")
    Column(modifier = Modifier.padding((20.dp))) {
        OutlinedTextField(
            value = operacio,
            onValueChange = { onValueChange(it) },
            enabled = false,
            readOnly = true,
            label = { Text("Operacio") },
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth()
    ) {
        operacions.forEach { seleccio ->
            DropdownMenuItem(text = { Text(text = seleccio) }, onClick = {
                expanded = false
                onValueChange(seleccio)
            })
        }
    }
}

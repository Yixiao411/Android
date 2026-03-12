package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculadora(modifier: Modifier){
    var op1 by remember { mutableStateOf("") }
    var op2 by remember { mutableStateOf("") }
    var operacio by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()) {
        TextField(value = op1,
            onValueChange = {
                op1 = it
            }
        )

        TextField(value = op2,
            onValueChange = {
                op2 = it
            }
        )

        MyDropDownMenu(operacio){
            operacio = it
        }
    }
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

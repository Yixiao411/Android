package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Lemonade(modifier: Modifier = Modifier.fillMaxSize()){
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var requiredSqueezes by remember { mutableStateOf((2..4).random()) }

    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (currentStep) {
        1 -> "Agafa una llimona"
        2 -> "Esprem la llimona"
        3 -> "Beu-te-la"
        else -> "Comença de nou"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            modifier = Modifier.clickable{
                when(currentStep){
                    1 -> {
                        currentStep = 2
                        requiredSqueezes = (2..10).random()
                        squeezeCount = 0
                    }
                    2 -> {
                        squeezeCount++
                        if (squeezeCount >= requiredSqueezes) {
                            currentStep = 3
                        }
                    }
                    3 -> currentStep = 4
                    4 -> currentStep = 1
                }
            }
        )
        Text(text = textResource)
    }
}
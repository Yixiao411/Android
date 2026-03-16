package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceRoller(modifier: Modifier = Modifier.fillMaxSize()){
    var diceNumber1 by remember { mutableStateOf(0) }
    var diceNumber2 by remember { mutableStateOf(0) }

    var diceFace = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    var context = LocalContext.current

    Image(
        painterResource(R.drawable.tapestry),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.title),
            contentDescription = null,
            modifier = Modifier.width(320.dp),
            contentScale = ContentScale.Crop
        )

        Button(
            colors = ButtonColors(Color.Red,Color.White,Color.Red, Color.Black),
            modifier = Modifier.fillMaxWidth(0.8f),
            onClick = {
                diceNumber1 = (0..5).random()
                diceNumber2 = (0..5).random()
            }
        ){
            Text(text = "Roll the Dice",
                fontSize = 20.sp)

        }

        Row(){
            Image(
                painter = painterResource(diceFace[diceNumber1]),
                contentDescription = null,
                modifier = Modifier.clickable(){
                    diceNumber1 = (0..5).random()
                }
            )
            Image(
                painter = painterResource(diceFace[diceNumber2]),
                contentDescription = null,
                modifier = Modifier.clickable(){
                    diceNumber2 = (0..5).random()
                }
            )
        }

        if (diceNumber1 == 5 && diceNumber2 == 5){
            Toast.makeText(context, "JACKPOT!",Toast.LENGTH_SHORT).show()
        }
    }
}

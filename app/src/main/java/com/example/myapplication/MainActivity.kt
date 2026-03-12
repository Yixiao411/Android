package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    //Exercici1(modifier = Modifier.padding(innerPadding))
                    //Ex1(modifier = Modifier.padding(innerPadding))
                    //Ex2(modifier = Modifier.padding(innerPadding))
                    //Ex3(modifier = Modifier.padding(innerPadding))
                    CalculadoraPropina(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()
        Box(modifier = Modifier.size(120.dp).background(Color.Red).constrainAs(boxRed){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Yellow))
        Box(modifier = Modifier.size(120.dp).background(Color.Green))
        Box(modifier = Modifier.size(120.dp).background(Color.Cyan))
        Box(modifier = Modifier.size(120.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Image(
            painter = painterResource(id = R.drawable.pika), contentDescription = "Example")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MyConstraintLayout(Modifier.padding(innerPadding))
        }
    }
}
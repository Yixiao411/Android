package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ex3(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(top = 20.dp)
    ) {
        Row(Modifier.weight(1f)) {
            Box(Modifier
                .fillMaxSize().weight(1f)
                .background(Color(0xFFEADDFF)),
                contentAlignment = Alignment.Center) {
                Column() {
                    Text("Text composable", fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                    Text("Displays text and follows the recommended Material Design guidelines.",
                        Modifier.padding(10.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Box(Modifier
                .fillMaxSize().weight(1f)
                .background(Color(0xFFD0BCFF)),
                contentAlignment = Alignment.Center) {
                Column() {
                    Text("Image composable", fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                    Text("Creates a composable that lays out and draws a given Painter class object.",
                        Modifier.padding(10.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }

        Row(Modifier.weight(1f)) {
            Box(Modifier
                .fillMaxSize().weight(1f)
                .background(Color(0xFFB69DF8)),
                contentAlignment = Alignment.Center) {
                Column() {
                    Text("Row composable", fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                    Text("A layout composable that places its children in a horizontal sequence.",
                        Modifier.padding(10.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Box(Modifier
                .fillMaxSize().weight(1f)
                .background(Color(0xFFF6EDFF)),
                contentAlignment = Alignment.Center) {
                Column() {
                    Text("Column composable", fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                    Text("A layout composable that places its children in a vertical sequence.",
                        Modifier.padding(10.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}
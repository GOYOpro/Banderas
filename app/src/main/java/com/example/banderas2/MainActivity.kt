package com.example.banderas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas2.ui.theme.Banderas2Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Banderas2Theme {
                PedroSanchezHP()
            }
        }
    }
}

@Composable
fun PedroSanchezHP(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
       Box(
           modifier = Modifier
               .fillMaxSize()
               .padding(innerPadding),
           contentAlignment = Alignment.Center
       ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth(0.8f)
                   .height(200.dp),

           ) {
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .fillMaxWidth()
                       .background(Color.Red)
               )
               Box(
                   modifier = Modifier
                       .weight(2f)
                       .fillMaxWidth()
                       .background(Color.Yellow),
                   contentAlignment = Alignment.Center
               ){
                   Image(
                       modifier = Modifier
                           .padding(end = 90.dp),
                       painter = painterResource(id = R.drawable.españa),
                       contentDescription = "Escudo de españa.drawable ostias"
                   )
               }
               Box(
                   modifier = Modifier
                       .weight(1f)
                       .fillMaxWidth()
                       .background(Color.Red)
               )
           }
       }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Banderas2Theme {
        PedroSanchezHP()
    }
}
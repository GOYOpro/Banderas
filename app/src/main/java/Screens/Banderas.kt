package Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.banderas2.R

@Composable

/*Composable padre es el bandera screen*/
//Nombre del parametro,valor
fun BanderaScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding()
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(colorResource(id = R.color.VerdeM)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.M),
                color = colorResource(id = R.color.RojoM),
                fontSize = 100.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(colorResource(id = R.color.RojoM)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.x),
                color = colorResource(id = R.color.VerdeMexico),
                fontSize = 100.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaPreviwe() {
    BanderaScreen()
}
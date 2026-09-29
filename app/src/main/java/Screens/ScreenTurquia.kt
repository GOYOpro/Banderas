package Screens

import android.graphics.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import android.R.attr.path
@Composable
fun ScreenTurquia(modifier: Modifier = Modifier){
    Canvas(modifier = modifier.fillMaxSize()){
        drawRect(color = Color.Red)
        val cy = size.height / 2
        val  rOut = size.height * 0.30f
        drawCircle(color = Color.White, radius =  rOut,
            center = Offset(size.width * 0.38f,cy))

        drawCircle(color = Color.Red, radius = size.height * 0.24f,
            center = Offset(size.width * 0.38f + size.height * 0.09f, cy))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ScreenTurquia(modifier = Modifier.fillMaxSize())
}
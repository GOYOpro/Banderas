package Screens

import android.graphics.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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

        val starCenterX = size.width * 0.38f + size.height * 0.38f
        val starCenterY = cy
        val outerRadius = size.height * 0.12f
        val innerRadius = outerRadius * 0.382f

        val path = Path()
        val totalPoints = 10
        val angleStep = Math.PI / 5 // 36 grados
        val startAngle = -Math.PI / 2 // Orientada hacia la derecha/arriba

        for (i in 0 until totalPoints) {
            val r = if (i % 2 == 0) outerRadius else innerRadius
            val angle = startAngle + i * angleStep
            val x = (starCenterX + r * Math.cos(angle)).toFloat()
            val y = (starCenterY + r * Math.sin(angle)).toFloat()

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }
        path.close()

        drawPath(path = path, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ScreenTurquia(modifier = Modifier.fillMaxSize())
}
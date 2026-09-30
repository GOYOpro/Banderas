package Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas2.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import kotlin.math.cos
import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import kotlin.math.sin
import androidx.compose.ui.graphics.drawscope.Stroke
fun trianglePath(cx: Float, cy: Float, r: Float, rotationDeg: Float): Path {
    val path = Path()
    for (i in 0..2) {
        val angle = Math.toRadians((rotationDeg + i * 120).toDouble())
        val x = cx + r * cos(angle).toFloat()
        val y = cy + r * sin(angle).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Composable
fun ScreenIsrael(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(colorResource(id = R.color.azul))
            ) {}

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(colorResource(id = R.color.azul))
            ) {}
            Spacer(modifier = Modifier.height(20.dp))
        }

        val azulColor = colorResource(id = R.color.azul)
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val cx = size.width / 2f
            val cy = size.height / 2f
            val radius = 60.dp.toPx()

            val pathUp = trianglePath(cx, cy, radius, -90f)
            val pathDown = trianglePath(cx, cy, radius, 90f)

            val strokeStyle = Stroke(width = 8f)

            drawPath(path = pathUp, color = azulColor, style = strokeStyle)
            drawPath(path = pathDown, color = azulColor, style = strokeStyle)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ScreenIsrael(modifier = Modifier.fillMaxSize())
}
package com.example.banderas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas2.ui.theme.Banderas2Theme
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import kotlin.math.sin
import kotlin.math.cos
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Banderas2Theme {
                Cuba()
            }
        }
    }
}

fun starPath(cx: Float, cy: Float, outerRadius: Float, innerRadius: Float): Path {
    val path = Path()
    val points = 5
    val angleStep = Math.PI / points

    for (i in 0 until (points * 2)) {
        val r = if (i % 2 == 0) outerRadius else innerRadius
        val angle = i * angleStep - Math.PI / 2
        val x = cx + (r * cos(angle)).toFloat()
        val y = cy + (r * sin(angle)).toFloat()

        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }
    path.close()
    return path
}
@Composable
fun Cuba(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            repeat(5) { index ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(
                            if (index % 2 == 0) colorResource(id = R.color.azulfuerte) else Color.White
                        )
                )
            }
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val triWidth = size.width * 0.38f

            // Construir Triángulo
            val trianglePath = Path().apply {
                moveTo(0f, 0f)
                lineTo(triWidth, size.height / 2f)
                lineTo(0f, size.height)
                close()
            }

            // Dibujar Triángulo Rojo
            drawPath(
                path = trianglePath,
                color = Color(0xFFCB1428)
            )

            // Centro geométrico para colocar la estrella dentro del triángulo
            val starCenterX = triWidth * 0.38f
            val starCenterY = size.height / 2f

            val outerRadius = 24.dp.toPx()
            val innerRadius = outerRadius * 0.382f

            // Dibujar Estrella Blanca
            drawPath(
                path = starPath(starCenterX, starCenterY, outerRadius, innerRadius),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Banderas2Theme {
        Cuba()
    }
}
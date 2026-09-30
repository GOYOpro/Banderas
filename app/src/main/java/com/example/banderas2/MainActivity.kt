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
                Seychelles()
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
fun Seychelles(modifier: Modifier = Modifier) {
    val azul = colorResource(id = R.color.azulfuerte)
    val amarillo = Color(0xFFFFD100)
    val rojo = Color(0xFFD21034)
    val blanco = Color.White
    val verde = Color(0xFF007A3D)

    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val origin = Offset(0f, h) // Esquina inferior izquierda

        // 1. Franja Azul (Triángulo en el borde superior)
        val pathAzul = Path().apply {
            moveTo(origin.x, origin.y)
            lineTo(0f, 0f)             // Esquina superior izquierda
            lineTo(w * (1f / 3f), 0f)   // 1/3 del ancho superior
            close()
        }
        drawPath(path = pathAzul, color = azul)

        val pathAmarillo = Path().apply {
            moveTo(origin.x, origin.y)
            lineTo(w * (1f / 3f), 0f)
            lineTo(w * (2f / 3f), 0f)   // 2/3 del ancho superior
            close()
        }
        drawPath(path = pathAmarillo, color = amarillo)

        // 3. Franja Roja (Polígono que incluye la esquina superior derecha)
        val pathRojo = Path().apply {
            moveTo(origin.x, origin.y)
            lineTo(w * (2f / 3f), 0f)
            lineTo(w, 0f)               // Esquina superior derecha
            lineTo(w, h * (1f / 3f))     // 1/3 del alto derecho
            close()
        }
        drawPath(path = pathRojo, color = rojo)

        val pathBlanco = Path().apply {
            moveTo(origin.x,origin.y)
            lineTo(w, h * (1f/3f))
            lineTo(w, h * (2f/3f))
            close()
        }
        drawPath(path = pathBlanco, color = Color.White)

        val pathVerde = Path().apply {
            moveTo(origin.x, origin.y)
            lineTo(w, h * (2f / 3f))
            lineTo(w, h)
            close()
        }
        drawPath(path = pathVerde, color = verde)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Banderas2Theme {
        Seychelles()
    }
}
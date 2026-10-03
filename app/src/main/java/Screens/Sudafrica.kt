package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.unit.dp
import kotlin.io.path.Path
import androidx.compose.foundation.layout.height
import java.nio.file.Files.size
import androidx.compose.foundation.Canvas
import android.system.Os.close
import androidx.compose.ui.graphics.StrokeCap
import kotlin.io.path.moveTo
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import  androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.sin
import  kotlin.math.cos
import androidx.compose.ui.graphics.drawscope.Stroke
@Composable
fun ScreensButan() {
    val colorAmarillo = Color(0xFFFFCC00)
    val colorNaranja = Color(0xFFFF4E00)
    val colorBlanco = Color.White

    Box(
        modifier = Modifier
            .width(360.dp)
            .height(240.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // 1. Fondo Naranja completo
            drawRect(color = colorNaranja)

            // 2. Triángulo Amarillo (Mitad superior izquierda)
            val trianguloAmarillo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(0f, h)
                close()
            }
            drawPath(path = trianguloAmarillo, color = colorAmarillo)

            // 3. Silueta del Dragón en diagonal (Path con curvas bezier quadraticTo)
            val dragonPath = Path().apply {
                // Cabeza en la parte inferior izquierda
                moveTo(w * 0.38f, h * 0.52f)
                quadraticTo(w * 0.35f, h * 0.58f, w * 0.30f, h * 0.62f)
                quadraticTo(w * 0.38f, h * 0.55f, w * 0.42f, h * 0.50f)

                // Ondulaciones del cuerpo
                quadraticTo(w * 0.48f, h * 0.40f, w * 0.52f, h * 0.48f)
                quadraticTo(w * 0.58f, h * 0.34f, w * 0.64f, h * 0.42f)
                quadraticTo(w * 0.72f, h * 0.28f, w * 0.78f, h * 0.36f)

                // Cola
                quadraticTo(w * 0.82f, h * 0.30f, w * 0.80f, h * 0.38f)

                // Borde inferior trazado de regreso
                quadraticTo(w * 0.72f, h * 0.34f, w * 0.64f, h * 0.48f)
                quadraticTo(w * 0.58f, h * 0.40f, w * 0.52f, h * 0.54f)
                quadraticTo(w * 0.48f, h * 0.46f, w * 0.42f, h * 0.54f)
                close()
            }

            // Dibuja el cuerpo blanco del dragón con trazo grueso
            drawPath(
                path = dragonPath,
                color = colorBlanco
            )
            drawPath(
                path = dragonPath,
                color = colorBlanco,
                style = Stroke(width = h * 0.08f)
            )

            // 4. Estrellas doradas/amarillas sobre el dragón
            val posicionesEstrellas = listOf(
                Offset(w * 0.42f, h * 0.43f),
                Offset(w * 0.53f, h * 0.46f),
                Offset(w * 0.65f, h * 0.40f),
                Offset(w * 0.76f, h * 0.35f)
            )

            for (pos in posicionesEstrellas) {
                dibujarEstrella(
                    centro = pos,
                    radioExterior = h * 0.045f,
                    radioInterior = h * 0.02f,
                    color = colorAmarillo
                )
            }
        }
    }
}

private fun DrawScope.dibujarEstrella(
    centro: Offset,
    radioExterior: Float,
    radioInterior: Float,
    color: Color
) {
    val path = Path()
    val anguloPaso = Math.PI / 5

    for (i in 0 until 10) {
        val r = if (i % 2 == 0) radioExterior else radioInterior
        val angulo = i * anguloPaso - (Math.PI / 2)
        val x = centro.x + (r * cos(angulo)).toFloat()
        val y = centro.y + (r * sin(angulo)).toFloat()

        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }
    path.close()
    drawPath(path = path, color = color)
}

@Preview(showBackground = true)
@Composable
fun Preview(){
ScreensButan()}
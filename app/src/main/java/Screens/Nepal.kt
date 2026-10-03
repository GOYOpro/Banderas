package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import  androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.sin
import  kotlin.math.cos
import androidx.compose.ui.graphics.drawscope.Stroke
@Composable
fun ScreensNepal() {
    val colorCarmesi = Color.Red
    val colorAzulMarino = Color.Blue
    val colorBlanco = Color.White

    Canvas(
        modifier = Modifier
            .width(240.dp)
            .height(320.dp)
    ) {
        val w = size.width
        val h = size.height
        val strokeBorde = h * 0.035f

        // 1. PATH DEL TRIÁNGULO SUPERIOR
        val trianguloSuperior = Path().apply {
            moveTo(0f, 0f)
            lineTo(w * 0.95f, h * 0.48f)
            lineTo(0f, h * 0.54f)
            close()
        }

        // 2. PATH DEL TRIÁNGULO INFERIOR
        val trianguloInferior = Path().apply {
            moveTo(0f, h * 0.52f)
            lineTo(w * 0.82f, h * 0.68f)
            lineTo(0f, h)
            close()
        }

        // Dibujar relleno carmesí de ambos triángulos
        drawPath(path = trianguloSuperior, color = colorCarmesi)
        drawPath(path = trianguloInferior, color = colorCarmesi)

        // Dibujar borde grueso azul marino exterior
        drawPath(
            path = trianguloSuperior,
            color = colorAzulMarino,
            style = Stroke(width = strokeBorde)
        )
        drawPath(
            path = trianguloInferior,
            color = colorAzulMarino,
            style = Stroke(width = strokeBorde)
        )

        // 3. DIBUJAR LA LUNA CRECIENTE CON PUNTOS (Triángulo superior)
        val centroLuna = Offset(w * 0.32f, h * 0.28f)
        val radioLuna = h * 0.07f

        // Arco base de la luna
        drawCircle(
            color = colorBlanco,
            radius = radioLuna,
            center = centroLuna
        )
        // Recorte superior para formar la media luna
        drawCircle(
            color = colorCarmesi,
            radius = radioLuna * 0.85f,
            center = Offset(centroLuna.x, centroLuna.y - radioLuna * 0.35f)
        )

        // Puntos/Rayos alrededor de la luna (8 puntos)
        val numPuntosLuna = 8
        val radioPuntos = radioLuna * 1.35f
        val pasoAnguloLuna = Math.PI / (numPuntosLuna - 1)

        for (i in 0 until numPuntosLuna) {
            val angulo = Math.PI - (i * pasoAnguloLuna)
            val px = centroLuna.x + (radioPuntos * cos(angulo)).toFloat()
            val py = centroLuna.y + (radioPuntos * sin(angulo)).toFloat()
            drawCircle(
                color = colorBlanco,
                radius = h * 0.012f,
                center = Offset(px, py)
            )
        }

        // 4. DIBUJAR EL SOL DE 12 PUNTAS (Triángulo inferior)
        val centroSol = Offset(w * 0.32f, h * 0.78f)
        dibujarSol12Puntas(
            centro = centroSol,
            radioExterior = h * 0.08f,
            radioInterior = h * 0.042f,
            color = colorBlanco
        )
    }
}


private fun DrawScope.dibujarSol12Puntas(
    centro: Offset,
    radioExterior: Float,
    radioInterior: Float,
    color: Color
) {
    val path = Path()
    val puntas = 12
    val anguloPaso = Math.PI / puntas

    for (i in 0 until (puntas * 2)) {
        val r = if (i % 2 == 0) radioExterior else radioInterior
        val angulo = i * anguloPaso
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
ScreensNepal()
}
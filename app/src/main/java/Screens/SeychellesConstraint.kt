package Screens
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ScreensPapua(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(240.dp)
            .background(Color.Black)
    ) {
        val canvasRef = createRef()

        Canvas(
            modifier = Modifier
                .constrainAs(canvasRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            val w = size.width
            val h = size.height

            // 1. Triángulo Rojo Superior (de la esquina superior izquierda a la inferior derecha)
            val pathRojo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(w, h)
                close()
            }
            drawPath(path = pathRojo, color = Color.Red)

            // 2. Triángulo Negro Inferior (rellena el fondo sobrante)
            val pathNegro = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathNegro, color = Color.Black)

            // Función auxiliar para dibujar estrellas de N puntas
            fun drawStar(center: Offset, radiusOuter: Float, radiusInner: Float, points: Int = 5, color: Color = Color.White) {
                val starPath = Path()
                val angleStep = PI / points
                var angle = -PI / 2 // Orientación hacia arriba

                for (i in 0 until 2 * points) {
                    val r = if (i % 2 == 0) radiusOuter else radiusInner
                    val x = center.x + r * cos(angle).toFloat()
                    val y = center.y + r * sin(angle).toFloat()

                    if (i == 0) {
                        starPath.moveTo(x, y)
                    } else {
                        starPath.lineTo(x, y)
                    }
                    angle += angleStep
                }
                starPath.close()
                drawPath(path = starPath, color = color)
            }

            // 3. Estrellas de la Cruz del Sur (Mitad Negra)[cite: 12]
            // Estrella superior (Alpha)
            drawStar(center = Offset(w * 0.50f, h * 0.18f), radiusOuter = 12f, radiusInner = 5f)
            // Estrella derecha (Beta)
            drawStar(center = Offset(w * 0.63f, h * 0.38f), radiusOuter = 12f, radiusInner = 5f)
            // Estrella izquierda (Gamma)
            drawStar(center = Offset(w * 0.35f, h * 0.52f), radiusOuter = 12f, radiusInner = 5f)
            // Estrella inferior (Delta)
            drawStar(center = Offset(w * 0.50f, h * 0.72f), radiusOuter = 12f, radiusInner = 5f)
            // Estrella pequeña (Epsilon - 5 puntas o menor tamaño)
            drawStar(center = Offset(w * 0.43f, h * 0.82f), radiusOuter = 6f, radiusInner = 2.5f)

            // 4. Ave del Paraíso estilizada en amarillo (Mitad Roja)[cite: 12]
            // Representación vectorial del ave mediante estrella/símbolo según especificación práctica[cite: 12]
            drawStar(
                center = Offset(w * 0.25f, h * 0.38f),
                radiusOuter = 40f,
                radiusInner = 16f,
                points = 4,
                color = Color.Yellow
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaPapuaNuevaGuineaConstraintPreview() {
        ScreensPapua()
}

package Screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.geometry.Size
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.res.colorResource
import com.example.banderas2.R
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
@Composable
fun ScreensButan(modifier: Modifier = Modifier) {
    val colorNaranja = Color(0xFFFF4E00)
    val colorJoyas = Color(0xFFFFD100)
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(240.dp)
            .background(colorNaranja)
    ) {
        // Guidelines para delimitar las restricciones del Canvas
        val guideTop = createGuidelineFromTop(0f)
        val guideBottom = createGuidelineFromBottom(0f)
        val guideStart = createGuidelineFromStart(0f)
        val guideEnd = createGuidelineFromEnd(0f)

        val canvasRef = createRef()

        Canvas(
            modifier = Modifier
                .constrainAs(canvasRef) {
                    top.linkTo(guideTop)
                    bottom.linkTo(guideBottom)
                    start.linkTo(guideStart)
                    end.linkTo(guideEnd)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            val w = size.width
            val h = size.height

            // 1. DIVISIÓN DIAGONAL
            // Triángulo Superior Amarillo (Esquina inferior izquierda a esquina superior derecha)
            val pathAmarillo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathAmarillo, color = Color.Yellow)

            // Triángulo Inferior Naranja
            val pathNaranja = Path().apply {
                moveTo(w, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathNaranja, color = colorNaranja)

            // 2. SILUETA SIMPLIFICADA DEL DRAGÓN BLANCO EN LA DIAGONAL
            val grosorCuerpo = h * 0.08f

            // Cuerpo en zigzag que sigue la diagonal
            val pathDragón = Path().apply {
                moveTo(w * 0.28f, h * 0.78f) // Cola (esquina inferior izquierda)
                lineTo(w * 0.38f, h * 0.65f)
                lineTo(w * 0.48f, h * 0.70f)
                lineTo(w * 0.58f, h * 0.52f)
                lineTo(w * 0.68f, h * 0.58f)
                lineTo(w * 0.78f, h * 0.38f) // Cabeza/Cuello (esquina superior derecha)
            }

            drawPath(
                path = pathDragón,
                color = Color.White,
                style = Stroke(
                    width = grosorCuerpo,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )

            // Cabeza del Dragón (Vértices estilizados)
            val pathCabeza = Path().apply {
                moveTo(w * 0.78f, h * 0.38f)
                lineTo(w * 0.85f, h * 0.35f)
                lineTo(w * 0.82f, h * 0.28f)
                close()
            }
            drawPath(path = pathCabeza, color = Color.White)

            // Patas/Garras del Dragón que sobresalen de las curvas
            val pathGarras = Path().apply {
                // Garra trasera inferior
                moveTo(w * 0.38f, h * 0.65f)
                lineTo(w * 0.32f, h * 0.58f)
                // Garra delantera superior
                moveTo(w * 0.68f, h * 0.58f)
                lineTo(w * 0.74f, h * 0.66f)
            }
            drawPath(
                path = pathGarras,
                color = Color.White,
                style = Stroke(width = grosorCuerpo * 0.6f, cap = StrokeCap.Round)
            )

            // 3. JOYAS / ESTRELLAS AMARILLAS EN LAS GARRAS Y EL CUERPO
            fun drawStar(center: Offset, radiusOuter: Float, radiusInner: Float, points: Int = 5) {
                val starPath = Path()
                val angleStep = PI / points
                var angle = -PI / 2

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
                drawPath(path = starPath, color = colorJoyas)
            }

            // Ubicación de las 4 joyas a lo largo del cuerpo del dragón
            val radioJoyas = h * 0.035f
            drawStar(center = Offset(w * 0.32f, h * 0.58f), radiusOuter = radioJoyas, radiusInner = radioJoyas * 0.4f)
            drawStar(center = Offset(w * 0.48f, h * 0.70f), radiusOuter = radioJoyas, radiusInner = radioJoyas * 0.4f)
            drawStar(center = Offset(w * 0.58f, h * 0.52f), radiusOuter = radioJoyas, radiusInner = radioJoyas * 0.4f)
            drawStar(center = Offset(w * 0.74f, h * 0.66f), radiusOuter = radioJoyas, radiusInner = radioJoyas * 0.4f)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSudafrica() {
    ScreensButan()
}

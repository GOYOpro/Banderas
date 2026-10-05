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
import androidx.compose.foundation.layout.Box
import androidx.constraintlayout.compose.Dimension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.Canvas
import kotlin.io.path.Path
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.geometry.Offset
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
@Composable
fun ScreensNepal(modifier: Modifier = Modifier) {
    val colorNaranja = Color(0xFFFF4E00)
    val colorJoyas = Color(0xFFFFD100)
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(240.dp)
            .background(Color.White)
    ) {
        val guideTop = createGuidelineFromTop(0f)
        val guideBottom = createGuidelineFromBottom(0f)
        val guideStart = createGuidelineFromStart(0f)
        val guideEnd = createGuidelineFromEnd(0f)

        val mainContainer = createRef()

        Box(
            modifier = Modifier.constrainAs(mainContainer) {
                top.linkTo(guideTop)
                bottom.linkTo(guideBottom)
                start.linkTo(guideStart)
                end.linkTo(guideEnd)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {
            // -------------------------------------------------------------
            // ESTRUCTURA CON COLUMN Y ROW (Divide verticalmente los 2 pennants)
            // -------------------------------------------------------------
            Column(modifier = Modifier.fillMaxSize()) {
                // Sección superior (Triángulo superior)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize())
                }

                // Sección inferior (Triángulo inferior)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize())
                }
            }

            // -------------------------------------------------------------
            // CANVAS EN CAPA SUPERPUESTA (Trazado no rectangular de Nepal)
            // -------------------------------------------------------------
            Canvas(modifier = Modifier.fillMaxSize()) {
                val w = size.width
                val h = size.height

                val strokeBorde = h * 0.035f

                // Silueta de los dos triángulos apilados (pennants)
                val pathNepal = Path().apply {
                    moveTo(0f, 0f)                          // Esquina superior izquierda
                    lineTo(w * 0.95f, h * 0.48f)            // Vértice superior
                    lineTo(w * 0.22f, h * 0.48f)            // Muesca / Entrante central
                    lineTo(w * 0.82f, h * 0.88f)            // Vértice inferior
                    lineTo(0f, h)                           // Esquina inferior izquierda
                    close()
                }

                // Relleno Carmesí
                drawPath(path = pathNepal, color = Color.Red)

                // Borde Azul Marino Grueso
                drawPath(
                    path = pathNepal,
                    color = Color.Blue,
                    style = Stroke(width = strokeBorde)
                )

                // Función auxiliar para dibujar soles de N puntas
                fun drawSun(center: Offset, radiusOuter: Float, radiusInner: Float, points: Int) {
                    val sunPath = Path()
                    val angleStep = PI / points
                    var angle = -PI / 2

                    for (i in 0 until 2 * points) {
                        val r = if (i % 2 == 0) radiusOuter else radiusInner
                        val x = center.x + r * cos(angle).toFloat()
                        val y = center.y + r * sin(angle).toFloat()

                        if (i == 0) {
                            sunPath.moveTo(x, y)
                        } else {
                            sunPath.lineTo(x, y)
                        }
                        angle += angleStep
                    }
                    sunPath.close()
                    drawPath(path = sunPath, color = Color.White)
                }

                // 1. TRIÁNGULO SUPERIOR: LUNA Y SOL DE 8 PUNTAS
                val centerLuna = Offset(w * 0.28f, h * 0.26f)
                val rLunaOut = h * 0.07f
                val rLunaIn = h * 0.058f

                drawCircle(color = Color.White, radius = rLunaOut, center = centerLuna)
                drawCircle(color = Color.Red, radius = rLunaIn, center = Offset(centerLuna.x, centerLuna.y - h * 0.022f))

                drawSun(
                    center = Offset(centerLuna.x, centerLuna.y + h * 0.015f),
                    radiusOuter = h * 0.052f,
                    radiusInner = h * 0.025f,
                    points = 8
                )

                // 2. TRIÁNGULO INFERIOR: SOL DE 12 PUNTAS
                val centerSolInferior = Offset(w * 0.26f, h * 0.68f)
                drawSun(
                    center = centerSolInferior,
                    radiusOuter = h * 0.075f,
                    radiusInner = h * 0.038f,
                    points = 12
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNepañ() {
   ScreensNepal()
}

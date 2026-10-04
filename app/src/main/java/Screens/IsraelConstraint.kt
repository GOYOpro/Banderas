package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.background
import androidx.constraintlayout.compose.Dimension
import androidx.compose.foundation.Canvas
import kotlin.io.path.Path
import androidx.compose.ui.graphics.Path
import kotlin.io.path.moveTo
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
@Composable
fun ScreensIsrael(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .aspectRatio(3f / 2f)
            .background(Color.White)
    ) {
        // 1. Declaración de referencias para las franjas y la estrella
        val (franjaSuperior, franjaInferior, hexagramaCanvas) = createRefs()

        // 2. Líneas guía para posicionar las dos franjas azules (al 12% y 88% de la altura)
        val glFranjaSuperiorTop = createGuidelineFromTop(0.12f)
        val glFranjaSuperiorBottom = createGuidelineFromTop(0.28f)

        val glFranjaInferiorTop = createGuidelineFromBottom(0.28f)
        val glFranjaInferiorBottom = createGuidelineFromBottom(0.12f)

        // Franja azul superior restringida con líneas guía
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(franjaSuperior) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(glFranjaSuperiorTop)
                    bottom.linkTo(glFranjaSuperiorBottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        // Franja azul inferior restringida con líneas guía
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(franjaInferior) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(glFranjaInferiorTop)
                    bottom.linkTo(glFranjaInferiorBottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        // 3. Canvas con la Estrella de David (Hexagrama) centrado entre ambas franjas[cite: 10]
        Canvas(
            modifier = Modifier
                .constrainAs(hexagramaCanvas) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(franjaSuperior.bottom)
                    bottom.linkTo(franjaInferior.top)
                    width = Dimension.percent(0.4f)
                    height = Dimension.ratio("1:1") // Mantiene el área de la estrella cuadrada
                }
        ) {
            val centroX = size.width / 2f
            val centroY = size.height / 2f

            val triWidth = size.width * 0.9f
            val triHeight = size.height * 0.85f
            val strokeWidth = size.height * 0.09f

            // Triángulo 1: Apuntando hacia arriba ▲
            val trianguloArriba = Path().apply {
                moveTo(centroX, centroY - (triHeight * 0.5f))
                lineTo(centroX + (triWidth / 2f), centroY + (triHeight * 0.35f))
                lineTo(centroX - (triWidth / 2f), centroY + (triHeight * 0.35f))
                close()
            }

            // Triángulo 2: Apuntando hacia abajo ▼ (rotado 180°)[cite: 10]
            val trianguloAbajo = Path().apply {
                moveTo(centroX, centroY + (triHeight * 0.5f))
                lineTo(centroX + (triWidth / 2f), centroY - (triHeight * 0.35f))
                lineTo(centroX - (triWidth / 2f), centroY - (triHeight * 0.35f))
                close()
            }

            // Trazo de las líneas del hexagrama
            drawPath(
                path = trianguloArriba,
                color = Color.Blue,
                style = Stroke(width = strokeWidth)
            )
            drawPath(
                path = trianguloAbajo,
                color = Color.Blue,
                style = Stroke(width = strokeWidth)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIsrael(){
   ScreensIsrael()
}

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import kotlin.math.atan2
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.geometry.Size
import androidx.constraintlayout.compose.Dimension
import kotlin.io.path.Path
import androidx.compose.ui.graphics.Path
@Composable
fun ScreensSudafrica(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(240.dp)
            .background(Color.White)
    ) {
        // Guidelines de ConstraintLayout para fijar los límites del Canvas
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

            // 1. Fondos superior e inferior
            drawRect(
                color = Color.Blue,
                topLeft = Offset(0f, 0f),
                size = Size(w, h / 2f)
            )
            drawRect(
                color = Color.Yellow,
                topLeft = Offset(0f, h / 2f),
                size = Size(w, h / 2f)
            )

            // Punto de convergencia (apex)
            val apex = Offset(w * 0.36f, h / 2f)

            // 2. Trazado blanco grueso (Borde exterior de la Y)[cite: 13]
            val grosorBlanco = h * 0.30f
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = apex,
                strokeWidth = grosorBlanco,
                cap = StrokeCap.Square
            ) //[cite: 13]
            drawLine(
                color = Color.White,
                start = Offset(0f, h),
                end = apex,
                strokeWidth = grosorBlanco,
                cap = StrokeCap.Square
            ) //[cite: 13]
            drawLine(
                color = Color.White,
                start = apex,
                end = Offset(w, h / 2f),
                strokeWidth = grosorBlanco,
                cap = StrokeCap.Square
            ) //[cite: 13]

            // 3. Trazado verde más delgado superpuesto[cite: 13]
            val grosorVerde = h * 0.20f
            drawLine(
                color = Color.Green,
                start = Offset(0f, 0f),
                end = apex,
                strokeWidth = grosorVerde,
                cap = StrokeCap.Square
            )
            drawLine(
                color = Color.Green,
                start = Offset(0f, h),
                end = apex,
                strokeWidth = grosorVerde,
                cap = StrokeCap.Square
            )
            drawLine(
                color = Color.Green,
                start = apex,
                end = Offset(w, h / 2f),
                strokeWidth = grosorVerde,
                cap = StrokeCap.Square
            )

            // 4. Triángulo negro del asta[cite: 13]
            val pathNegro = Path().apply {
                moveTo(0f, 0f)
                lineTo(apex.x - (h * 0.08f), apex.y)
                lineTo(0f, h)
                close()
            }
            drawPath(path = pathNegro, color = Color.Black)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSudafrica() {
    ScreensSudafrica()
}

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
@Composable
fun ScreensRU(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(240.dp)
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
                Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
            }
        }

        // -------------------------------------------------------------
        // CAPA 2: Canvas para trazar Diagonales con rotate() y Cruces
        // -------------------------------------------------------------
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val centerOffset = Offset(w / 2f, h / 2f)

            val grosorDiagonalBlanca = h * 0.20f
            val grosorDiagonalRoja = h * 0.06f
            val grosorCruzBlanca = h * 0.33f
            val grosorCruzRoja = h * 0.20f

            // Ángulo de inclinación de la diagonal según la relación de aspecto
            val angleDeg = Math.toDegrees(atan2(h.toDouble(), w.toDouble())).toFloat()

            // 1. Aspa Diagonal Blanca Gruesa
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = Offset(w, h),
                strokeWidth = grosorDiagonalBlanca,
                cap = StrokeCap.Square
            )
            drawLine(
                color = Color.White,
                start = Offset(w, 0f),
                end = Offset(0f, h),
                strokeWidth = grosorDiagonalBlanca,
                cap = StrokeCap.Square
            )

            // 2. Aspa Diagonal Roja inclinada con rotate()
            // Diagonal de arriba-izquierda a abajo-derecha
            rotate(degrees = angleDeg, pivot = centerOffset) {
                drawLine(
                    color = Color.Red,
                    start = Offset(0f, centerOffset.y - grosorDiagonalRoja),
                    end = Offset(centerOffset.x, centerOffset.y - grosorDiagonalRoja),
                    strokeWidth = grosorDiagonalRoja
                )
                drawLine(
                    color = Color.Red,
                    start = Offset(centerOffset.x, centerOffset.y + grosorDiagonalRoja),
                    end = Offset(w, centerOffset.y + grosorDiagonalRoja),
                    strokeWidth = grosorDiagonalRoja
                )
            }

            // Diagonal de abajo-izquierda a arriba-derecha
            rotate(degrees = -angleDeg, pivot = centerOffset) {
                drawLine(
                    color = Color.Red,
                    start = Offset(0f, centerOffset.y + grosorDiagonalRoja),
                    end = Offset(centerOffset.x, centerOffset.y + grosorDiagonalRoja),
                    strokeWidth = grosorDiagonalRoja
                )
                drawLine(
                    color = Color.Red,
                    start = Offset(centerOffset.x, centerOffset.y - grosorDiagonalRoja),
                    end = Offset(w, centerOffset.y - grosorDiagonalRoja),
                    strokeWidth = grosorDiagonalRoja
                )
            }

            // 3. Cruz Recta Blanca Centrada
            drawRect(
                color = Color.White,
                topLeft = Offset((w - grosorCruzBlanca) / 2f, 0f),
                size = Size(grosorCruzBlanca, h)
            )
            drawRect(
                color = Color.White,
                topLeft = Offset(0f, (h - grosorCruzBlanca) / 2f),
                size = Size(w, grosorCruzBlanca)
            )

            // 4. Cruz Recta Roja Centrada
            drawRect(
                color = Color.Red,
                topLeft = Offset((w - grosorCruzRoja) / 2f, 0f),
                size = Size(grosorCruzRoja, h)
            )
            drawRect(
                color = Color.Red,
                topLeft = Offset(0f, (h - grosorCruzRoja) / 2f),
                size = Size(w, grosorCruzRoja)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRU() {
    ScreensRU()
}

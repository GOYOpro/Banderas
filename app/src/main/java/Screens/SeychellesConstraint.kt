package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Canvas
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Offset
import android.util.Log.w
@Composable
fun ScreensSeychelles(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(200.dp)
            .background(Color.White)
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
            // 1. PRIMERO DECLARAS w, h Y origin AQUÍ:
            val w = size.width
            val h = size.height
            val origin = Offset(0f, h)

            // 2. AHORA SÍ DIBUJAS LOS PATHS:
            val pathAzul = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(0f, 0f)
                lineTo(w / 3f, 0f)
                close()
            }
            drawPath(path = pathAzul, color = Color.Blue)

            val pathAmarillo = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(w / 3f, 0f)
                lineTo(2f * w / 3f, 0f)
                close()
            }
            drawPath(path = pathAmarillo, color = Color.Yellow)

            val pathRojo = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(2f * w / 3f, 0f)
                lineTo(w, 0f)
                lineTo(w, h / 3f)
                close()
            }
            drawPath(path = pathRojo, color = Color.Red)

            val pathBlanco = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(w, h / 3f)
                lineTo(w, 2f * h / 3f)
                close()
            }
            drawPath(path = pathBlanco, color = Color.White)

            val pathVerde = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(w, 2f * h / 3f)
                lineTo(w, h)
                close()
            }
            drawPath(path = pathVerde, color = Color.Green)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCuba(){
    ScreensSeychelles()
}

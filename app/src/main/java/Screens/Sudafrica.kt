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

@Composable
fun BanderaSudafrica() {
    val colorAzul = Color(0xFF002395)
    val colorDorado = Color(0xFFFFB81C)
    val colorVerde = Color(0xFF007A4D)
    val colorBlanco = Color.White
    val colorNegro = Color.Black

    Box(
        modifier = Modifier
            .width(360.dp)
            .height(240.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height


            drawRect(
                color = colorAzul,
                topLeft = Offset(0f, 0f),
                size = Size(w, h / 2f)
            )
            drawRect(
                color = colorDorado,
                topLeft = Offset(0f, h / 2f),
                size = Size(w, h / 2f)
            )


            val apex = Offset(w * 0.36f, h / 2f)

            val strokeGrosorBlanco = h * 0.30f
            val strokeGrosorVerde = h * 0.20f


            drawLine(
                color = colorBlanco,
                start = Offset(0f, 0f),
                end = apex,
                strokeWidth = strokeGrosorBlanco,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorBlanco,
                start = Offset(0f, h),
                end = apex,
                strokeWidth = strokeGrosorBlanco,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorBlanco,
                start = apex,
                end = Offset(w, h * 0.14f),
                strokeWidth = strokeGrosorBlanco,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorBlanco,
                start = apex,
                end = Offset(w, h * 0.86f),
                strokeWidth = strokeGrosorBlanco,
                cap = StrokeCap.Square
            )


            drawLine(
                color = colorVerde,
                start = Offset(0f, 0f),
                end = apex,
                strokeWidth = strokeGrosorVerde,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorVerde,
                start = Offset(0f, h),
                end = apex,
                strokeWidth = strokeGrosorVerde,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorVerde,
                start = apex,
                end = Offset(w, h * 0.14f),
                strokeWidth = strokeGrosorVerde,
                cap = StrokeCap.Square
            )
            drawLine(
                color = colorVerde,
                start = apex,
                end = Offset(w, h * 0.86f),
                strokeWidth = strokeGrosorVerde,
                cap = StrokeCap.Square
            )


            val trianguloNegroPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(w * 0.28f, h / 2f)
                lineTo(0f, h)
                close()
            }
            drawPath(
                path = trianguloNegroPath,
                color = colorNegro
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    BanderaSudafrica()
}
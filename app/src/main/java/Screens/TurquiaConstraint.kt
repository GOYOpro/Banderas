package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.draw.rotate
import androidx.compose.foundation.Canvas
import kotlin.io.path.Path
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathOperation
@Composable
fun ScreensTurquia(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .aspectRatio(3f / 2f)
            .background(Color.Red)
    ) {
        val (lunaCanvas, estrella) = createRefs()

        val glCentroLuna = createGuidelineFromAbsoluteLeft(0.38f)

        // 1. DIBUJO DE LA LUNA AFILADA CON PATH.DIFFERENCE (Operación Booleana de recorte)
        Canvas(
            modifier = Modifier
                .size(140.dp)
                .constrainAs(lunaCanvas) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(glCentroLuna)
                    end.linkTo(glCentroLuna)
                }
        ) {
            val centroX = size.width / 2f
            val centroY = size.height / 2f
            val radioExterior = size.width * 0.45f
            val radioInterior = size.width * 0.36f

            // Círculo base blanco
            val pathExterior = Path().apply {
                addOval(
                    androidx.compose.ui.geometry.Rect(
                        center = Offset(centroX, centroY),
                        radius = radioExterior
                    )
                )
            }

            // Círculo recortador (desplazado levemente a la derecha)
            val pathInterior = Path().apply {
                addOval(
                    androidx.compose.ui.geometry.Rect(
                        center = Offset(centroX + (radioExterior * 0.30f), centroY),
                        radius = radioInterior
                    )
                )
            }

            // Resta pathInterior a pathExterior para obtener la luna afilada
            val lunaAfiladaPath = Path().apply {
                op(pathExterior, pathInterior, PathOperation.Difference)
            }

            drawPath(path = lunaAfiladaPath, color = Color.White)
        }

        // 2. ESTRELLA POSICIONADA CON CONSTRAINTLAYOUT
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Estrella",
            tint =Color.White,
            modifier = Modifier
                .size(52.dp)
                .rotate(-20f) // Inclinación hacia la boca de la luna
                .constrainAs(estrella) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(lunaCanvas.end, margin = (-18).dp)
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSuiza(){
    ScreensTurquia()
}

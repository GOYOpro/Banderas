package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.constraintlayout.compose.Dimension
import androidx.compose.foundation.Canvas
import kotlin.io.path.Path
import androidx.compose.ui.graphics.Path
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height

@Composable
fun ScreensCuba(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .width(360.dp)
            .height(200.dp)
            .background(Color.White)
    ) {

        val (franja1, franja2, franja3, franja4, franja5, trianguloRojo, estrella) = createRefs()


        val gl20 = createGuidelineFromTop(0.20f)
        val gl40 = createGuidelineFromTop(0.40f)
        val gl60 = createGuidelineFromTop(0.60f)
        val gl80 = createGuidelineFromTop(0.80f)

        val glTrianguloAncho = createGuidelineFromAbsoluteLeft(0.433f)

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(franja1) {
                    top.linkTo(parent.top)
                    bottom.linkTo(gl20)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(franja3) {
                    top.linkTo(gl40)
                    bottom.linkTo(gl60)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(franja5) {
                    top.linkTo(gl80)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        //Triángulo rojo equilátero dibujado sobre el lado del asta[cite: 11]
        Canvas(
            modifier = Modifier
                .constrainAs(trianguloRojo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(glTrianguloAncho)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            val triPath = Path().apply {
                moveTo(0f, 0f) // Esquina superior izquierda
                lineTo(size.width, size.height / 2f) // Vértice apuntando al centro[cite: 11]
                lineTo(0f, size.height) // Esquina inferior izquierda
                close()
            }
            drawPath(path = triPath, color = Color.Red)
        }

        //  Línea guía vertical colocada en el centroide matemático del triángulo (x = 1/3 del ancho del triángulo)
        val glCentroideEstrella = createGuidelineFromAbsoluteLeft(0.144f)

        // Estrella blanca centrada geométricamente dentro del triángulo[cite: 11]
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Estrella blanca de Cuba",
            tint = Color.White,
            modifier = Modifier
                .width(42.dp)
                .aspectRatio(1f)
                .constrainAs(estrella) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(glCentroideEstrella)
                    end.linkTo(glCentroideEstrella)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCuba(){
   ScreensCuba()
}

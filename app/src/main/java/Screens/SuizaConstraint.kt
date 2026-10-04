package Screens
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import  androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.sin
import  kotlin.math.cos
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.constraintlayout.compose.ConstraintLayout
import java.nio.file.WatchEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
@Composable
fun ScreensSuiza(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = Modifier
    ) {
        val glVerticalIzquierda = createGuidelineFromAbsoluteLeft(0.39f)
        val glVerticalDerecha = createGuidelineFromAbsoluteRight(0.39f)

        val glHorizontalSuperior = createGuidelineFromTop(0.39f)
        val glHorizontalInferior = createGuidelineFromBottom(0.39f)

        val glLargoIzquierda = createGuidelineFromAbsoluteLeft(0.19f)
        val glLargoDerecha = createGuidelineFromAbsoluteRight(0.19f)


        val glLargoSuperior = createGuidelineFromTop(0.19f)
        val glLargoInferior = createGuidelineFromBottom(0.19f)


        val (barraVertical, barraHorizontal) = createRefs()


        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(barraVertical) {
                    top.linkTo(glLargoSuperior)
                    bottom.linkTo(glLargoInferior)
                    start.linkTo(glVerticalIzquierda)
                    end.linkTo(glVerticalDerecha)
                }
        )


        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(barraHorizontal) {
                    top.linkTo(glHorizontalSuperior)
                    bottom.linkTo(glHorizontalInferior)
                    start.linkTo(glLargoIzquierda)
                    end.linkTo(glLargoDerecha)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSuiza(){
        ScreensSuiza(modifier = Modifier.fillMaxSize())
}
package Screens
import Screens.ArgentinaConstraint
import android.graphics.pdf.content.PdfPageGotoLinkContent
import android.media.Image
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.banderas2.R
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.layout.layout
import androidx.constraintlayout.compose.ChainStyle
import androidx.compose.foundation.shape.GenericShape

val RomboBrasil = GenericShape{size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}


@Composable
fun ArgentinaConstraint(modifier: Modifier = Modifier){
    ConstraintLayout(
        modifier = modifier
    ) {
        val (FranjaSuperior,FranjaMedia,FranjaInferior) = createRefs()
        val (Rombo) = createRefs()
        val (Sol) = createRefs()
        val linea1 = createGuidelineFromTop(0.33f)
        val linea2 = createGuidelineFromTop(0.66f)
        ConstraintLayout(
            modifier = Modifier
                .background(colorResource(id = R.color.VerdeMexico))
                .constrainAs(FranjaSuperior){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                    height = Dimension.value(80.dp)
                    width = Dimension.fillToConstraints
                }
        ){}

        ConstraintLayout(
            modifier = Modifier
                .background(colorResource(id = R.color.VerdeMexico))
                .constrainAs(FranjaMedia){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea2)
                    height = Dimension.value(80.dp)
                    width = Dimension.fillToConstraints
                }
        ) {
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .clip(RomboBrasil)
                    .background(colorResource(id = R.color.amarrilo))
                    .constrainAs(Rombo){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo( parent.bottom)
                    }
            ){}

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.azul))
                    .constrainAs(Sol){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo( parent.bottom)
                    }
            )
        }

        ConstraintLayout(
            modifier = modifier
                .background(colorResource(id = R.color.VerdeMexico))
                .constrainAs(FranjaInferior){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea2)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.value(80.dp)
                    width = Dimension.fillToConstraints
                }
        ) { }
        createVerticalChain(FranjaSuperior,FranjaMedia,FranjaInferior, chainStyle = ChainStyle.Packed)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    ArgentinaConstraint(modifier = Modifier.fillMaxSize())
}
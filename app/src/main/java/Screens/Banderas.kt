package Screens
import Screens.EspañaConstraint
import android.graphics.pdf.content.PdfPageGotoLinkContent
import android.media.Image
import android.provider.MediaStore
import androidx.compose.foundation.background
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.constraintlayout.compose.ChainStyle

@Composable
fun EspañaConstraint(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier)
    {
        val (FranjaSuperior,FranjaMedia,FranjaInferior) = createRefs()
        val linea1 = createGuidelineFromTop(0.33f)
        val linea2 = createGuidelineFromTop(0.66f)
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.Rojo))
                .constrainAs(FranjaSuperior){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    height = Dimension.value(80.dp)
                    width = Dimension.fillToConstraints
                }
        ){}
        ConstraintLayout(
            modifier = modifier
                .background(colorResource(id = R.color.amarrilo))
                .constrainAs(FranjaMedia){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(FranjaSuperior.bottom)
                    height = Dimension.value(80.dp)
                    width = Dimension.fillToConstraints
                }
        ) {}

        ConstraintLayout(
            modifier = modifier
                .background(colorResource(id = R.color.Rojo))
                .constrainAs(FranjaInferior){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(FranjaMedia.bottom)
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
    EspañaConstraint(modifier = Modifier.fillMaxSize())
}
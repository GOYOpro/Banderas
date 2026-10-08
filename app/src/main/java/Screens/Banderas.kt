package Screens

import android.media.Image
import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
@Composable
fun BanderaScreenFrancia(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (caja, caja1, caja2) = createRefs()

        val lineguia1 = createGuidelineFromAbsoluteLeft(0.33f)
        val lineguia2 = createGuidelineFromAbsoluteLeft(0.66f)

        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.azul))
                .constrainAs(caja) {
                    start.linkTo(parent.start)
                    end.linkTo(lineguia1)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        ConstraintLayout(
            modifier = Modifier
                .background(colorResource(id = R.color.white))
                .constrainAs(caja1) {
                    start.linkTo(lineguia1)
                    end.linkTo(lineguia2)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        ) { }

        ConstraintLayout(
            modifier = Modifier
                .background(colorResource(id = R.color.Rojo))
                .constrainAs(caja2){
                    start.linkTo(lineguia2)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaPreviwe() {
    BanderaScreenFrancia(modifier = Modifier.fillMaxSize())
}



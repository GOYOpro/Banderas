package Screen

import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SuizaScreen(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(Color.Red)
    ) {
        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.62f)
                .background(Color.White)
        ){}

        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.62f)
                .background(Color.White)
        ){}
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    SuizaScreen(modifier = Modifier.fillMaxSize())
}
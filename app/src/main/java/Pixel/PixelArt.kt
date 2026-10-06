import android.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Matrix
import pixel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import java.time.Clock.offset
import java.nio.file.Files.size

val pixel = arrayOf(
    intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
    intArrayOf(0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0),
    intArrayOf(0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0),
    intArrayOf(0,0,0,0,0,2,1,1,1,1,1,1,1,2,0,0,0,0),
    intArrayOf(0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0),
    intArrayOf(0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(0,0,0,1,1,1,3,2,3,3,3,2,3,1,1,1,1,0),
    intArrayOf(0,0,1,1,1,3,2,2,2,2,2,2,2,3,1,1,1,0),
    intArrayOf(0,0,1,1,1,3,2,2,2,2,2,2,2,3,1,1,1,0),
    intArrayOf(0,0,1,1,1,3,3,2,2,2,2,2,2,3,1,1,1,0),
    intArrayOf(0,0,1,1,1,3,3,2,2,2,2,2,3,3,1,1,1,0),
    intArrayOf(0,0,1,1,1,3,3,3,2,2,2,2,3,3,1,1,1,0),
    intArrayOf(0,0,0,1,1,1,3,3,3,2,2,3,3,1,1,1,1,0),
    intArrayOf(0,0,0,1,1,2,2,2,2,3,3,2,2,2,2,1,0,0),
    intArrayOf(0,0,0,1,1,1,1,3,3,3,3,3,1,1,1,1,0,0),
    intArrayOf(0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(2,2,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0),
    intArrayOf(2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2),
    intArrayOf(2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2),
    intArrayOf(2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2),
    intArrayOf(2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
    intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
    intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
)

@Composable
fun PixelArt(matrix: Array<IntArray>){
    val colores = mapOf(
        0 to Color(0xFF8A9A86),
        1 to Color(0xFFE5DACB),
        2 to Color(0xFF2A2222),
        3 to Color(0xFFC77C85)
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val rows = matrix.size
        val cols = matrix[0].size
        val cellwidth = size.width / cols
        val cellHeigth = size.height / rows

        for (r in 0 until rows){
            for (c in 0 until cols){
                val colorVal = matrix[r][c]
                val color = colores[colorVal] ?: Color.Black
                drawRect(
                    color = color,
                    topLeft = Offset(c * cellwidth, r *  cellHeigth),
                    size = Size(cellwidth , cellHeigth)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPixelArt(){
    PixelArt(matrix = pixel)
}
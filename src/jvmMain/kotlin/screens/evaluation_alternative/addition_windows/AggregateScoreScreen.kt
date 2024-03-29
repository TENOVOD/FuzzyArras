package screens.evaluation_alternative.addition_windows

import GLOBAL_AGGREGATE_SCORE
import GLOBAL_COUNT_CRITERIA
import GLOBAL_COUNT_EXPERT
import GLOBAL_MATRIX_OF_CRITERIA
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.unit.dp
import navcontroller.NavController
import screens.elements.*
import java.io.File



@Composable
fun AggregateScoreScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize().padding(start = 100.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                shape = RoundedCornerShape(size = 5.dp),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .padding(15.dp)
                    .width(1750.dp)
                    .height(800.dp)
                    .fillMaxHeight(0.5f)
                    .background(Color(255, 153, 255).copy(alpha = 0.3f)),
                color = Color.Transparent,
            ) {
                Column (
                    modifier = Modifier.padding(10.dp)
                ){

                    Row(){
                        HeaderCell("")
                        for(i in 1..GLOBAL_COUNT_CRITERIA){
                            HeaderCell(GLOBAL_MATRIX_OF_CRITERIA[i-1].name)
                        }
                    }

                    GLOBAL_AGGREGATE_SCORE.forEach {
                        Row {
                            LeftSideMainCell(it.altName)
                            for(c in 1..GLOBAL_COUNT_CRITERIA){
                                var cellText = "<"
                                for(i in 0 until GLOBAL_COUNT_EXPERT){
                                    cellText+="${it.table[c]!![i]}, "
                                }
                                cellText+=">"
                                TableCellWithText("$cellText")
                            }

                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                BasicButton("До оцінки альтернатив", modifier = Modifier.padding(12.dp).padding(1.dp).height(50.dp)) {
                    navController.navigate(Screen.EvaluationAlternative.name)
                }

            }
        }

    }
}
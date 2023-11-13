package screens.evaluation_criteria

import GLOBAL_COUNT_CRITERIA
import GLOBAL_COUNT_EXPERT
import GLOBAL_MATRIX_OF_CRITERIA_EVALUATION
import GLOBAl_CRITERIA_LT
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import models.getCriteriaById
import navcontroller.NavController
import screens.elements.BasicButton
import screens.elements.DropdownEvaluationCriteria
import screens.elements.HeaderCell
import screens.elements.LeftSideMainCell

@Composable
fun EvaluationCriteria(
    navController: NavController
) {
    val minLTName = GLOBAl_CRITERIA_LT[0].fullName
    if(GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[0].values[1]=="00"){
        for(i in GLOBAL_MATRIX_OF_CRITERIA_EVALUATION.indices){
            for(j in 1..GLOBAL_COUNT_EXPERT){
                GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[i].values[j]=minLTName
            }
        }
    }
    
    Box(
        modifier = Modifier.fillMaxSize().padding(start = 100.dp)
    ) {
        Column {
            Surface(
                shape = RoundedCornerShape(size = 5.dp),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier
                    .padding(15.dp)
                    .width(1750.dp)
                    .height(800.dp)
                    .fillMaxHeight(0.5f),
                color = Color.Transparent,
            ) {
                Column (
                    modifier = Modifier.padding(10.dp)
                ){
                    Row(){
                        HeaderCell("")
                        for(i in 1..GLOBAL_COUNT_EXPERT){
                            HeaderCell("Expert #$i")
                        }
                    }
                    val list = mutableListOf<String>()
                    GLOBAl_CRITERIA_LT.forEach {
                        list.add(it.fullName)
                    }
                    GLOBAL_MATRIX_OF_CRITERIA_EVALUATION.forEach { el->
                        Row(horizontalArrangement = Arrangement.SpaceEvenly){
                            LeftSideMainCell(el.name)
                            for(i in 1..GLOBAL_COUNT_EXPERT){
                                DropdownEvaluationCriteria(list,i,el)
                            }
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                BasicButton("FIRST") {}
                BasicButton("Second") {}
            }
        }

    }

}

fun updateMapEvaluation(
    key:Int,
    name:String,
    newValue:String
){
    for(i in GLOBAL_MATRIX_OF_CRITERIA_EVALUATION.indices){
        if(GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[i].name==name){
            try {
                GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[i].values[key]=newValue
                println("DONE NEW VALUE ${GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[i].values[key]} ||| $newValue ")
            }catch (e:Exception){
                println("ERROOOOR UNAVAILBLE KEY")
            }
        }
    }
}


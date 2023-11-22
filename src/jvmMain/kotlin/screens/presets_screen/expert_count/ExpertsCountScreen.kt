package screens.presets_screen.expert_count

import GLOBAL_MATRIX_OF_EXPERTS
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.*
import navcontroller.NavController
import screens.elements.HeaderCell
import screens.elements.TableCell

@Composable
fun ExpertsName(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(start = 100.dp)
        ){

        }
    }
}

fun updateTableByExpertsCount(
    count:Int
){
    when(count){
        1->{
            GLOBAL_MATRIX_OF_EXPERTS= setForExpert
        }
        2->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor2Experts
        }
        3->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor3Experts
        }
        4->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor4Experts
        }
        5->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor5Experts
        }
        6->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor6Experts
        }
        7->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor7Experts
        }
        8->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor8Experts
        }
        9->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor9Experts
        }
        10->{
            GLOBAL_MATRIX_OF_EXPERTS= setFor10Experts
        }
    }
}

fun changeAllGlobalExpertsNameById(
    id:Int,
    name:String
){
    for(i in GLOBAL_MATRIX_OF_EXPERTS.indices){
        if(GLOBAL_MATRIX_OF_EXPERTS[i].id==id){
            GLOBAL_MATRIX_OF_EXPERTS[i].name=name
        }
    }

}
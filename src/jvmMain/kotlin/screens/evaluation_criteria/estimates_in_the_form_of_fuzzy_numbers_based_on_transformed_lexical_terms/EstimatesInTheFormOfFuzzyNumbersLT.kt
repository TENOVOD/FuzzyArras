package screens.evaluation_criteria.estimates_in_the_form_of_fuzzy_numbers_based_on_transformed_lexical_terms

import GLOBAL_CRITERIA_FUZZY_NUMBERS
import GLOBAL_MATRIX_OF_CRITERIA_EVALUATION
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import navcontroller.NavController
import screens.elements.BasicButton
import screens.elements.HeaderCell
import screens.elements.TableCellWithText

@Composable
fun EstimatesFormOfFuzzyNumbersTransformedLTScreen(
    navController: NavController
){
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
                        HeaderCell("l")
                        HeaderCell("l'")
                        HeaderCell("m")
                        HeaderCell("u'")
                        HeaderCell("u")
                    }
                    println("GLOBAL_CRITERIA_FUZZY_NUMBERS = $GLOBAL_MATRIX_OF_CRITERIA_EVALUATION")
                    GLOBAL_CRITERIA_FUZZY_NUMBERS.forEach {
                        Row(){
                            TableCellWithText(it.name)
                            TableCellWithText(it.lValue.toString())
                            TableCellWithText(it.lshtValue.toString())
                            TableCellWithText(it.mValue.toString())
                            TableCellWithText(it.ushtValue.toString())
                            TableCellWithText(it.uValue.toString())
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                BasicButton("GO TO PREVIOUS PAGE") {
                    navController.navigate(Screen.EvaluationCriteria.name)
                }
            }
        }

    }

}
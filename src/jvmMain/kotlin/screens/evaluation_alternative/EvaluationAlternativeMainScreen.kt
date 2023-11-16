package screens.evaluation_alternative

import GLOBAL_AGGREGATE_SCORE
import GLOBAL_COUNT_CRITERIA
import GLOBAL_EXPERTS_EVALUATION_LIST
import GLOBAL_MATRIX_OF_ALTERNATIVES
import GLOBAL_MATRIX_OF_CRITERIA
import GLOBAl_ALTERNATIVE_LT
import SELECTED_EXPERT_INDEX
import Screen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.getAggregateStore

import models.calculateCriteriaFuzzyNumbers
import navcontroller.NavController
import screens.elements.*
import screens.evaluation_criteria.normalizeAlternativeLT
import javax.swing.GroupLayout.Alignment

@Composable
fun EvaluationAlternativeScreen(
    navController: NavController
) {
    normalizeAlternativeLT()
    Box(
        modifier = Modifier.fillMaxSize().padding(start = 100.dp)
    ) {
        Row {
            Column {
                Surface(
                    shape = RoundedCornerShape(size = 5.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(15.dp)
                        .width(1350.dp)
                        .height(800.dp)
                        .fillMaxHeight(0.5f),
                    color = Color.Transparent,
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ){
                        var selectedIndex by remember { mutableStateOf(SELECTED_EXPERT_INDEX) }
                        var expanded by remember { mutableStateOf(false) }
                        var expertAlternativeEvaluation by remember { mutableStateOf(GLOBAL_EXPERTS_EVALUATION_LIST[selectedIndex])}
                        Row(verticalAlignment = androidx.compose.ui.Alignment.Bottom) {
                            Text("Current Expert: ")

                            DropdownChooseExpert(selectedIndex,expanded,
                                changeValue = {
                                    selectedIndex=it
                                    expanded=false
                                    SELECTED_EXPERT_INDEX=selectedIndex
                                    //expertAlternativeEvaluation=GLOBAL_EXPERTS_EVALUATION_LIST[selectedIndex]
                                },
                                onExpandedFalse = {
                                    expanded=false
                                },
                                onExpandedTrue = {
                                    expanded=true
                                })
                            //DropdownChooseExpert()
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row {
                            HeaderCell("")
                            for(i in GLOBAL_MATRIX_OF_CRITERIA){
                                HeaderCell(i.name)
                            }
                        }

                        println("Selected index: $selectedIndex ExpList: $expertAlternativeEvaluation")
                        val listOfAlternativeLt = mutableListOf<String>()
                        GLOBAl_ALTERNATIVE_LT.forEach {
                            listOfAlternativeLt.add(it.fullName)
                        }
                        var indexA = 0;
                        expertAlternativeEvaluation.table.forEach {
                            Row{
                                LeftSideMainCell(GLOBAL_MATRIX_OF_ALTERNATIVES[indexA].name)
                                for(c in 1..GLOBAL_COUNT_CRITERIA){
                                    DropdownAlternativeEvaluation(
                                        expertAlternativeEvaluation.table[indexA][c],
                                        indexA,
                                        c,
                                        selectedIndex,
                                        listOfAlternativeLt
                                    )

                                }
                            }
                            indexA++
                        }

                    }


                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    BasicButton("GO TO MAIN PAGE") {
                        //navController.navigate(Screen.FuzzyTriangularNumbers.name)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .width(400.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(size = 5.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(15.dp)
                        .width(1350.dp)
                        .height(800.dp)
                        .fillMaxHeight(0.5f),
                    color = Color.Transparent,
                ){
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Aggregate score") {
                            getAggregateStore()
                            navController.navigate(Screen.AggregateScoreScreen.name)
                            //navController.navigate(Screen.FuzzyTriangularNumbers.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Estimates in the form of fuzzy triangular numbers") {
                            getAggregateStore()
                            navController.navigate(Screen.EstimatesInTheFormOfFuzzyTriangularNumbersScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Estimates in the form of fuzzy numbers") {
                            navController.navigate(Screen.EstimatesInTheFormOfFuzzyNumberScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Optimal criteria values") {
                            navController.navigate(Screen.OptimalCriteriaValuesScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Normalized matrix") {
                            //navController.navigate(Screen.FuzzyTriangularNumbers.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Normalized weighted matrix") {
                            //navController.navigate(Screen.FuzzyTriangularNumbers.name)
                        }
                    }

                }

            }

        }
    }
}
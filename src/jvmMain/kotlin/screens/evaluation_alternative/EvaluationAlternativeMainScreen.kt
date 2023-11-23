package screens.evaluation_alternative

import GLOBAL_AGGREGATE_SCORE
import GLOBAL_COUNT_CRITERIA
import GLOBAL_EXPERTS_EVALUATION_LIST
import GLOBAL_MATRIX_OF_ALTERNATIVES
import GLOBAL_MATRIX_OF_CRITERIA
import GLOBAL_MATRIX_OF_EXPERTS
import GLOBAl_ALTERNATIVE_LT
import SELECTED_EXPERT_INDEX
import Screen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.getAggregateStore

import models.calculateCriteriaFuzzyNumbers
import navcontroller.NavController
import screens.elements.*
import screens.evaluation_alternative.addition_windows.NormalizedWeightedMatrixScreen
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
            Column(modifier = Modifier.fillMaxHeight()) {
                Surface(
                    shape = RoundedCornerShape(size = 5.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .padding(15.dp)
                        .background(Color(255, 153, 255).copy(alpha = 0.3f))
                        .width(1400.dp).verticalScroll(rememberScrollState()),
                    color = Color.Transparent,
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        println("1111GLOBAL_EXPERTS_EVALUATION_LIST")
                        GLOBAL_EXPERTS_EVALUATION_LIST.forEach {
                            println(it)
                        }
                        println("22222GLOBAL_EXPERTS_EVALUATION_LIST")

                        var indexExperts = 0
                        GLOBAL_EXPERTS_EVALUATION_LIST.forEach { ev ->
                            Text(GLOBAL_MATRIX_OF_EXPERTS[indexExperts].name,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(
                                    Font(
                                        resource = "Ermilov.otf",
                                        style = FontStyle.Normal,
                                        weight = FontWeight.Bold
                                    )
                                )
                            ))
                            Spacer(modifier = Modifier.height(10.dp))
                            Row {
                                HeaderCell("")
                                for (i in GLOBAL_MATRIX_OF_CRITERIA) {
                                    HeaderCell(i.name)
                                }
                            }
                            val listOfAlternativeLt = mutableListOf<String>()
                            GLOBAl_ALTERNATIVE_LT.forEach {
                                listOfAlternativeLt.add(it.fullName)
                            }
                            var indexA = 0;
                            ev.table.forEach {
                                Row {
                                    LeftSideMainCell(GLOBAL_MATRIX_OF_ALTERNATIVES[indexA].name)
                                    for (c in 1..GLOBAL_COUNT_CRITERIA) {
                                        DropdownAlternativeEvaluation(
                                            ev.table[indexA][c],
                                            indexA,
                                            c,
                                            ev.expertId-1,
                                            listOfAlternativeLt
                                        )

                                    }
                                }
                                indexA++
                            }

                            indexExperts++
                            Spacer(modifier = Modifier.height(30.dp))
                        }


                    }


                }
                Spacer(modifier = Modifier.height(20.dp))
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
                        .fillMaxHeight()
                        .background(Color(255, 153, 255).copy(alpha = 0.3f)),
                    color = Color.Transparent,
                ) {
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Агреговані оцінки", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),) {
                            getAggregateStore()
                            navController.navigate(Screen.AggregateScoreScreen.name)
                            //navController.navigate(Screen.FuzzyTriangularNumbers.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Оцінки у вигляді нечітких трикутних чисел", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),) {
                            getAggregateStore()
                            navController.navigate(Screen.EstimatesInTheFormOfFuzzyTriangularNumbersScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Оцінки у вигляді нечітких чисел", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),) {
                            navController.navigate(Screen.EstimatesInTheFormOfFuzzyNumberScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Оптимальні значення критеріїв", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),
                            ) {
                            navController.navigate(Screen.OptimalCriteriaValuesScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Нормована матриця", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),) {
                            navController.navigate(Screen.NormalizedMatrixScreen.name)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        BasicButton("Нормована зважена матриця", modifier = Modifier.padding(12.dp).padding(1.dp).fillMaxWidth().height(100.dp),) {

                            navController.navigate(Screen.NormalizedWeightedMatrixScreen.name)
                        }
                    }

                }

            }

        }
    }
}
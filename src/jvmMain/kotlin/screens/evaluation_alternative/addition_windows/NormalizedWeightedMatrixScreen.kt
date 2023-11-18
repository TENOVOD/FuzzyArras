package screens.evaluation_alternative.addition_windows

import GLOBAL_COUNT_ALTERNATIVE
import GLOBAL_COUNT_CRITERIA
import GLOBAL_CRITERIA_FUZZY_NUMBERS
import GLOBAL_MATRIX_OF_ALTERNATIVES
import GLOBAL_MATRIX_OF_CRITERIA
import GLOBAL_NORMALIZED_ALTERNATIVE_MATRIX
import GLOBAL_NORMALIZED_WEIGHTED_MATRIX
import GLOBAL_RESULT
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import models.AlternativeAndCriteriaFuzzyNumbers
import navcontroller.NavController
import screens.elements.BasicButton
import screens.elements.HeaderCell
import screens.elements.LeftSideMainCell
import screens.elements.TableCellWithText

@Composable
fun NormalizedWeightedMatrixScreen(
    navController: NavController
) {
    normalizeWeightedMatrix()
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
                    .fillMaxHeight(0.5f)
                    .verticalScroll(rememberScrollState()),

                color = Color.Transparent,
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    for (i in 0 until GLOBAL_COUNT_CRITERIA) {
                        Row() {
                            HeaderCell(GLOBAL_MATRIX_OF_CRITERIA[i].name)
                            HeaderCell("l")
                            HeaderCell("l'")
                            HeaderCell("m")
                            HeaderCell("u'")
                            HeaderCell("u")
                        }
                        var index = 0
                        GLOBAL_NORMALIZED_WEIGHTED_MATRIX.forEach {
                            if (it.first == GLOBAL_MATRIX_OF_CRITERIA[i].name) {
                                Row {
                                    if (index == 0) {
                                        LeftSideMainCell("Optimal alternative")
                                        TableCellWithText(it.second.lValue.toString())
                                        TableCellWithText(it.second.lshtValue.toString())
                                        TableCellWithText(it.second.mValue.toString())
                                        TableCellWithText(it.second.ushtValue.toString())
                                        TableCellWithText(it.second.uValue.toString())
                                        index++
                                    } else {
                                        var name = "$index"
                                        if (index < GLOBAL_COUNT_ALTERNATIVE + 1) {
                                            name = GLOBAL_MATRIX_OF_ALTERNATIVES[index - 1].name
                                        }
                                        LeftSideMainCell(name)
                                        TableCellWithText(it.second.lValue.toString())
                                        TableCellWithText(it.second.lshtValue.toString())
                                        TableCellWithText(it.second.mValue.toString())
                                        TableCellWithText(it.second.ushtValue.toString())
                                        TableCellWithText(it.second.uValue.toString())
                                        index++
                                    }
                                }

                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            calculateNormalizeMatrix()
            Row {
                BasicButton("GO TO PREVIOUS PAGE") {
                    navController.navigate(Screen.EvaluationAlternative.name)
                }
            }
        }

    }
}

fun normalizeWeightedMatrix() {
    GLOBAL_NORMALIZED_WEIGHTED_MATRIX.clear()

    GLOBAL_CRITERIA_FUZZY_NUMBERS.forEach { fn ->

        GLOBAL_NORMALIZED_ALTERNATIVE_MATRIX.forEach { el ->
            if (fn.name == el.first) {
                val lValue = fn.lValue * el.second.lValue
                val lshtValue = fn.lshtValue * el.second.lshtValue
                val mValue = fn.mValue * el.second.mValue
                val ushtValue = fn.ushtValue * el.second.ushtValue
                val uValue = fn.uValue * el.second.uValue
                val cell = AlternativeAndCriteriaFuzzyNumbers(
                    fn.name,
                    lValue,
                    lshtValue,
                    mValue,
                    ushtValue,
                    uValue
                )
                GLOBAL_NORMALIZED_WEIGHTED_MATRIX.add(el.first to cell)
            }
        }
    }
    transformFuzzyNumberToClearNumbers()

}

fun transformFuzzyNumberToClearNumbers() {
    GLOBAL_RESULT.clear()
    var indexCriteria = 0
    var maxIndexCriteria = GLOBAL_COUNT_CRITERIA - 1
    for (i in 0..GLOBAL_COUNT_ALTERNATIVE) {
        val tempAlternativeCriteriaFuzzyNumbers = GLOBAL_NORMALIZED_WEIGHTED_MATRIX[i].second
        var isFirstElement = true

        GLOBAL_NORMALIZED_WEIGHTED_MATRIX.forEach {
                if(isFirstElement){
                    isFirstElement=false
                }else{
                    if (indexCriteria % (GLOBAL_COUNT_ALTERNATIVE + 1) == 0) {
                        tempAlternativeCriteriaFuzzyNumbers.lValue += it.second.lValue
                        tempAlternativeCriteriaFuzzyNumbers.lshtValue += it.second.lshtValue
                        tempAlternativeCriteriaFuzzyNumbers.mValue += it.second.mValue
                        tempAlternativeCriteriaFuzzyNumbers.ushtValue += it.second.ushtValue
                        tempAlternativeCriteriaFuzzyNumbers.uValue += it.second.uValue

                    }
                }



            indexCriteria++
        }
        if (i == 0) {
            GLOBAL_RESULT.add("Optimal alternative" to tempAlternativeCriteriaFuzzyNumbers)
        } else {
            GLOBAL_RESULT.add(GLOBAL_MATRIX_OF_ALTERNATIVES[i - 1].name to tempAlternativeCriteriaFuzzyNumbers)
        }

    }
    println("RESSSSSUUUUULT")
    GLOBAL_RESULT.forEach {
        println(it)
    }
    println("FINISH")
}
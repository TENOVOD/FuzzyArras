package screens.presets_screen

import GLOBAL_COUNT_ALTERNATIVE
import GLOBAL_COUNT_CRITERIA
import GLOBAL_COUNT_EXPERT
import GLOBAl_ALTERNATIVE_LT
import GLOBAl_CRITERIA_LT
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.*
import models.Criteria
import models.LinguisticTermCell
import navcontroller.NavController
import screens.elements.*
import screens.presets_screen.alternative_count.AlternativeCountView

import screens.presets_screen.criteria_count.CriteriaCountView

import screens.presets_screen.experts_count.ExpertsCountView
import screens.presets_screen.linguistic_terms_for_evaluating_the_importance_of_criteria.updateDataAlternativeMatrix
import screens.presets_screen.linguistic_terms_for_evaluating_the_importance_of_criteria.updateDataMatrix

import screens.presets_screen.parts.сount_LT.CountLT





@Composable
fun PresentScreenView(
    navController: NavController
) {
    println("START ACTIVITY + ${GLOBAl_CRITERIA_LT}")
    var rememberCriteriaEvaluation by remember { mutableStateOf(3) }
    var rememberAlternativeEvaluation by remember { mutableStateOf(3) }
    val criteriaDataPoints = remember{ mutableStateListOf(listOf(0f,0f,0f))}
    val alternativeDataPoints = remember{ mutableStateListOf(listOf(0f,0f,0f))}
    var rememberCriteriaDataMatrix by remember { mutableStateOf(GLOBAl_CRITERIA_LT) }
    var rememberAlternativeDataMatrix by remember { mutableStateOf(setFor3LinguisticTerm) }


    println("Rememem")

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 100.dp)
    ) {
        Column(modifier = Modifier.width(700.dp)) {

            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Linguistic terms for evaluating the importance of criteria")
                Spacer(modifier = Modifier.height(10.dp))
                println("start column $rememberCriteriaDataMatrix")
                Row {
                    HeaderCell("Full name")
                    HeaderCell("Short name")
                    HeaderCell("")
                    HeaderCell("")
                    HeaderCell("")
                }
                when (rememberCriteriaEvaluation) {
                    3 -> {
                        rememberCriteriaDataMatrix = setFor3LinguisticTerm
                        println("$rememberCriteriaEvaluation in when")
                        GLOBAl_CRITERIA_LT = rememberCriteriaDataMatrix
                        updateDataMatrix(rememberCriteriaDataMatrix)
                    }

                    4 -> {
                        rememberCriteriaDataMatrix = setFor4LinguisticTerm
                        println("$rememberCriteriaEvaluation in when")
                        GLOBAl_CRITERIA_LT = rememberCriteriaDataMatrix
                        updateDataMatrix(rememberCriteriaDataMatrix)
                    }

                    5 -> {
                        rememberCriteriaDataMatrix = setFor5LinguisticTerm
                        println("$rememberCriteriaEvaluation in when")
                        GLOBAl_CRITERIA_LT = rememberCriteriaDataMatrix
                        updateDataMatrix(rememberCriteriaDataMatrix)
                    }

                    6 -> {
                        rememberCriteriaDataMatrix = setFor6LinguisticTerm
                        println("$rememberCriteriaEvaluation in when")
                        GLOBAl_CRITERIA_LT = rememberCriteriaDataMatrix
                        updateDataMatrix(rememberCriteriaDataMatrix)
                    }

                    7 -> {
                        rememberCriteriaDataMatrix = setFor7LinguisticTerm
                        println("$rememberCriteriaEvaluation in when")
                        GLOBAl_CRITERIA_LT = rememberCriteriaDataMatrix
                        updateDataMatrix(rememberCriteriaDataMatrix)
                    }


                }
                var preparationForDataPoint by remember { mutableStateOf(GLOBAl_CRITERIA_LT) }

                criteriaDataPoints.clear()
                var maxX by remember { mutableStateOf(0) }
                var xLabels = remember{ listOf("0")}
                val yLabels = remember { listOf("1 ", " ", " ", " ", " ", "0 ")}

                preparationForDataPoint.forEach {
                    if(maxX<it.thirdLimit.toFloat()){
                        maxX=it.thirdLimit.toInt()
                    }
                    criteriaDataPoints.add(listOf(it.firstLimit.toFloat(),it.secondLimit.toFloat(),it.thirdLimit.toFloat()))
                }
                xLabels= newXLabels(maxX)

                //Charts
                Row{
                    Column(
                        modifier = Modifier
                            .width(400.dp)
                            .padding(19.dp)
                    ) {
                        LineChartWithLabels(
                            dataPoints = criteriaDataPoints,
                            xLabels = xLabels,
                            yLabels = yLabels,
                            maxX = maxX.toFloat(),
                            modifier = Modifier
                        )
                        BasicButton(
                            "Update"
                        ){
                            preparationForDataPoint= GLOBAl_CRITERIA_LT
                            criteriaDataPoints.clear()
                            maxX=0
                            preparationForDataPoint.forEach {
                                if(maxX<it.thirdLimit.toFloat()){
                                    maxX=it.thirdLimit.toInt()
                                }
                                criteriaDataPoints.add(listOf(it.firstLimit.toFloat(),it.secondLimit.toFloat(),it.thirdLimit.toFloat()))
                            }
                            xLabels= newXLabels(maxX)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .width(400.dp)
                            .padding(19.dp)
                    ) {
                        LineChartWithLabels(
                            dataPoints = criteriaDataPoints,
                            xLabels = listOf("0","0.2","0.4","0.6","0.8","1"),
                            yLabels = yLabels,
                            maxX = maxX.toFloat(),
                            modifier = Modifier
                        )
                    }
                }

                /*
                for (row in rememberCriteriaDataMatrix) {
                    setMatrixOfLTForEvaluatingTheImportanceOfCriteria(
                        ltCell=row,
                        changeFullName = {row.fullName=it},
                        changeShortName = {row.onNewShortName},
                        changeFirstLimit = {row.onNewFirstLimit},
                        changeSecondLimit = {row.onNewSecondLimit},
                        changeThirdLimit = {row.onNewThirdLimit}
                    )
                }*/

            }
        }
        Column(modifier = Modifier.width(700.dp)) {

            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Linguistic terms for evaluating the importance of criteria")
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    HeaderCell("Full name")
                    HeaderCell("Short name")
                    HeaderCell("")
                    HeaderCell("")
                    HeaderCell("")
                }
                when (rememberAlternativeEvaluation) {
                    3 -> {
                        rememberAlternativeDataMatrix = setFor3LinguisticTerm
                        println("$rememberAlternativeEvaluation in when")
                        GLOBAl_ALTERNATIVE_LT = rememberAlternativeDataMatrix
                        updateDataAlternativeMatrix(rememberAlternativeDataMatrix)
                    }

                    4 -> {
                        rememberAlternativeDataMatrix = setFor4LinguisticTerm
                        println("$rememberAlternativeEvaluation in when")
                        GLOBAl_ALTERNATIVE_LT = rememberAlternativeDataMatrix
                        updateDataAlternativeMatrix(rememberAlternativeDataMatrix)
                    }

                    5 -> {
                        rememberAlternativeDataMatrix = setFor5LinguisticTerm
                        println("$rememberAlternativeEvaluation in when")
                        GLOBAl_ALTERNATIVE_LT = rememberAlternativeDataMatrix
                        updateDataAlternativeMatrix(rememberAlternativeDataMatrix)
                    }

                    6 -> {
                        rememberAlternativeDataMatrix = setFor6LinguisticTerm
                        println("$rememberAlternativeEvaluation in when")
                        GLOBAl_ALTERNATIVE_LT = rememberAlternativeDataMatrix
                        updateDataAlternativeMatrix(rememberAlternativeDataMatrix)
                    }

                    7 -> {
                        rememberAlternativeDataMatrix = setFor7LinguisticTerm
                        println("$rememberAlternativeEvaluation in when")
                        GLOBAl_ALTERNATIVE_LT = rememberAlternativeDataMatrix
                        updateDataAlternativeMatrix(rememberAlternativeDataMatrix)
                    }


                }
                var preparationForDataPoint by remember { mutableStateOf(GLOBAl_ALTERNATIVE_LT) }

                alternativeDataPoints.clear()
                var maxX by remember { mutableStateOf(0) }
                var xLabels = remember{ listOf("0")}
                val yLabels = remember { listOf("1 ", " ", " ", " ", " ", "0 ")}

                preparationForDataPoint.forEach {
                    if(maxX<it.thirdLimit.toFloat()){
                        maxX=it.thirdLimit.toInt()
                    }
                    alternativeDataPoints.add(listOf(it.firstLimit.toFloat(),it.secondLimit.toFloat(),it.thirdLimit.toFloat()))
                }
                xLabels= newXLabels(maxX)

                //Charts
                Row{
                    Column(
                        modifier = Modifier
                            .width(400.dp)
                            .padding(19.dp)
                    ) {
                        LineChartWithLabels(
                            dataPoints = alternativeDataPoints,
                            xLabels = xLabels,
                            yLabels = yLabels,
                            maxX = maxX.toFloat(),
                            modifier = Modifier
                        )
                        BasicButton(
                            "Update"
                        ){
                            preparationForDataPoint= GLOBAl_ALTERNATIVE_LT
                            alternativeDataPoints.clear()
                            maxX=0
                            preparationForDataPoint.forEach {
                                if(maxX<it.thirdLimit.toFloat()){
                                    maxX=it.thirdLimit.toInt()
                                }
                                alternativeDataPoints.add(listOf(it.firstLimit.toFloat(),it.secondLimit.toFloat(),it.thirdLimit.toFloat()))
                            }
                            xLabels= newXLabels(maxX)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .width(400.dp)
                            .padding(19.dp)
                    ) {
                        LineChartWithLabels(
                            dataPoints = alternativeDataPoints,
                            xLabels = listOf("0","0.2","0.4","0.6","0.8","1"),
                            yLabels = yLabels,
                            maxX = maxX.toFloat(),
                            modifier = Modifier
                        )
                    }
                }
            }
        }
        Column {
            //Counters LT
            CountLT(
                rememberCriteriaEvaluation,
                rememberAlternativeEvaluation,
                onAddCounterCriteriaValue = {
                    if (rememberCriteriaEvaluation < 7) {
                        rememberCriteriaEvaluation++
                    }
                },
                onRemoveCounterCriteriaValue = {
                    if (rememberCriteriaEvaluation > 3) {
                        rememberCriteriaEvaluation--
                    }
                },
                onAddCounterAlternativeValue = {
                    if (rememberAlternativeEvaluation < 7) {
                        rememberAlternativeEvaluation++
                    }
                },
                onRemoveCounterAlternativeValue = {
                    if (rememberAlternativeEvaluation > 3) {
                        rememberAlternativeEvaluation--
                    }
                }
            )

            //Criteria counter +-
            var rememberCriteriaCount by remember { mutableStateOf(2) }
            CriteriaCountView(
                rememberCriteriaCount,
                onAddCounterCriteriaValue = {
                    if (rememberCriteriaCount < 10) {
                        rememberCriteriaCount++
                        GLOBAL_COUNT_CRITERIA=rememberCriteriaCount
                    }
                },
                onRemoveCounterCriteriaValue = {
                    if (rememberCriteriaCount > 2) {
                        rememberCriteriaCount--
                        GLOBAL_COUNT_CRITERIA=rememberCriteriaCount
                    }
                },
                onCriteriaButtonAction = {
                    navController.navigate(Screen.SettingsScreen.name)
                }
            )

            //Alternative counter +-
            var rememberAlternativeCount by remember { mutableStateOf(2) }
            AlternativeCountView(
                rememberAlternativeCount,
                onAddCounterAlternativeValue = {
                    if (rememberAlternativeCount < 10) {
                        rememberAlternativeCount++
                        GLOBAL_COUNT_ALTERNATIVE=rememberAlternativeCount
                    }
                },
                onRemoveCounterAlternativeValue = {
                    if (rememberAlternativeCount > 2) {
                        rememberAlternativeCount--
                        GLOBAL_COUNT_ALTERNATIVE=rememberAlternativeCount
                    }
                },
                onAlternativeButtonAction = {
                    //////ADDDD
                }
            )

            // Expert counter +-
            var rememberExpertsCount by remember { mutableStateOf(1) }
            ExpertsCountView(
                rememberExpertsCount,
                onAddCounterExpertValue = {
                    if (rememberExpertsCount < 10) {
                        rememberExpertsCount++
                        GLOBAL_COUNT_EXPERT=rememberExpertsCount
                    }
                },
                onRemoveCounterExpertValue = {
                    if (rememberExpertsCount > 1) {
                        rememberExpertsCount--
                        GLOBAL_COUNT_EXPERT=rememberExpertsCount
                    }
                },
                onExpertsButton = {

                }
            )
            Text(text = rememberExpertsCount.toString())
        }
    }


}

fun updateDataInList(
    currentList: MutableList<LinguisticTermCell>,
    oldFullName: String,
): Int {
    var index = 0
    for (i in currentList.indices) {
        if (currentList[i].fullName == oldFullName) {
            index = i
        }
    }
    return index
}

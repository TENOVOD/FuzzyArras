package screens.presets_screen.alternatives_names

import GLOBAL_MATRIX_OF_ALTERNATIVES
import GLOBAL_MATRIX_OF_CRITERIA
import GLOBAL_MATRIX_OF_EXPERTS
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import screens.elements.BasicButton
import screens.elements.DropdownDemo
import screens.elements.HeaderCell
import screens.elements.TableCell
import screens.presets_screen.expert_count.changeAllGlobalExpertsNameById
import screens.presets_screen.settings_of_alternatives.changeAllGlobalCriteriaNameById

@Composable
fun AlternativesName(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(start = 100.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(size = 5.dp),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.padding(15.dp).background(Color(255, 153, 255).copy(alpha = 0.3f)).fillMaxHeight(),
                color = Color.Transparent
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Surface(
                            shape = RoundedCornerShape(size = 5.dp),
                            border = BorderStroke(1.dp, Color.Gray),
                            modifier = Modifier
                                .padding(15.dp)
                                .width(250.dp)
                                ,
                            color = Color.Transparent,
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    HeaderCell("Назва")
                                }
                                GLOBAL_MATRIX_OF_ALTERNATIVES.forEach { el ->

                                    Row(
                                        modifier = Modifier
                                            .width(500.dp)
                                    ) {
                                        var alternativeName by remember { mutableStateOf(el.name) }
                                        TableCell(alternativeName) {
                                            alternativeName = it
                                            changeAllGlobalAlternativeNameById(el.id, alternativeName)
                                        }
                                    }
                                }



                            }
                            Spacer(modifier = Modifier.height(10.dp))

                        }
                        Surface(
                            shape = RoundedCornerShape(size = 5.dp),
                            border = BorderStroke(1.dp, Color.Gray),
                            modifier = Modifier
                                .padding(15.dp)
                                .width(250.dp)
                                ,
                            color = Color.Transparent,
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    HeaderCell("Ім'я")
                                }
                                GLOBAL_MATRIX_OF_EXPERTS.forEach { el ->

                                    Row(
                                        modifier = Modifier
                                            .width(500.dp)
                                    ) {
                                        var alternativeName by remember { mutableStateOf(el.name) }
                                        TableCell(alternativeName) {
                                            alternativeName = it
                                            changeAllGlobalExpertsNameById(el.id, alternativeName)
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))

                        }
                        Surface(
                            shape = RoundedCornerShape(size = 5.dp),
                            border = BorderStroke(1.dp, Color.Gray),
                            modifier = Modifier
                                .padding(15.dp)
                                .width(500.dp)
                                ,
                            color = Color.Transparent,
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    HeaderCell("Назва")
                                    HeaderCell("Оптимальне значення")
                                }
                                GLOBAL_MATRIX_OF_CRITERIA.forEach { el ->

                                    Row(
                                        modifier = Modifier
                                            .width(500.dp)
                                    ) {
                                        var criterionName by remember { mutableStateOf(el.name) }
                                        TableCell(criterionName) {
                                            criterionName = it
                                            changeAllGlobalCriteriaNameById(el.id, criterionName)
                                        }
                                        DropdownDemo(el)
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    BasicButton(
                        "До налаштувань"
                    ){
                        println(GLOBAL_MATRIX_OF_EXPERTS)
                        navController.navigate(Screen.HomeScreen.name)
                    }
                }
            }
        }
    }
}

fun updateTableByAlternative(
    count: Int
) {
    when (count) {
        2 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor2Alternatives
        }

        3 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor3Alternatives
        }

        4 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor4Alternatives
        }

        5 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor5Alternatives
        }

        6 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor6Alternatives
        }

        7 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor7Alternatives
        }

        8 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor8Alternatives
        }

        9 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor9Alternatives
        }

        10 -> {
            GLOBAL_MATRIX_OF_ALTERNATIVES = setFor10Alternatives
        }
    }
}

fun changeAllGlobalAlternativeNameById(
    id: Int,
    name: String
) {
    for (i in GLOBAL_MATRIX_OF_ALTERNATIVES.indices) {
        if (GLOBAL_MATRIX_OF_ALTERNATIVES[i].id == id) {
            GLOBAL_MATRIX_OF_ALTERNATIVES[i].name = name
        }
    }

}
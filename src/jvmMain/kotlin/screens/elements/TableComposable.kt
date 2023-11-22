package screens.elements

import GLOBAL_AGGREGATE_SCORE
import GLOBAL_EXPERTS_EVALUATION_LIST
import GLOBAL_MATRIX_OF_CRITERIA_EVALUATION
import GLOBAL_MATRIX_OF_EXPERTS
import SELECTED_EXPERT_INDEX
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import models.*
import screens.evaluation_criteria.updateMapEvaluation
import screens.presets_screen.settings_of_alternatives.changeGlobalCriteriaMatrix
import javax.swing.GroupLayout.Alignment


@Composable
fun RowScope.HeaderCell(
    text: String
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(0.9f)
            .padding(2.dp)
            .width(100.dp)
            .height(60.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(
                Font(
                    resource = "Ermilov.otf",
                    style = FontStyle.Normal,
                    weight = FontWeight.W100
                )
            )
        )

    )
}

@Composable
fun RowScope.LeftSideMainCell(
    text: String
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(0.9f)
            .padding(2.dp)
            .width(100.dp)
            .height(60.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(
                Font(
                    resource = "Ermilov.otf",
                    style = FontStyle.Normal,
                    weight = FontWeight.W500
                )
            )
        )

    )
}

@Composable
fun RowScope.TableCell(
    value: String,

    onNewValue: (String) -> Unit,

    ) {
    BasicTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        modifier = Modifier
            .border(1.dp, Color.Black)
            .weight(0.9f)
            .padding(2.dp)
            .width(100.dp)
            .height(60.dp),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontFamily = FontFamily(
                Font(
                    resource = "Ermilov.otf",
                    style = FontStyle.Normal,
                    weight = FontWeight.W500
                )
            )
        ),
        cursorBrush=SolidColor(Color(255, 153, 255))



        )
}

@Composable
fun RowScope.TableCellWithText(
    value: String,
) {
    Text(
        text = value,
        modifier = Modifier
            .border(1.dp, Color.Black)
            .weight(0.9f)
            .padding(2.dp)
            .width(110.dp)
            .height(60.dp),
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontFamily = FontFamily(
                Font(
                    resource = "Ermilov.otf",
                    style = FontStyle.Normal,
                    weight = FontWeight.W100
                )
            )
        )
    )
}

@Composable
fun RowScope.DropdownDemo(
    criteria: Criteria
) {
    var expanded by remember { mutableStateOf(false) }
    val criteriaValue = if (criteria.type == TypeMinMax.MAX) 0 else 1
    val items = listOf(TypeMinMax.MAX.toString(), TypeMinMax.MIN.toString())
    var selectedIndex by remember { mutableStateOf(criteriaValue) }
    Column {
        Text(
            items[selectedIndex],
            modifier = Modifier.border(1.dp, Color.Black).width(250.dp).height(64.dp).padding(start = 7.dp, top = 4.dp)
                .clickable(onClick = { expanded = true }).background(
                Color.Transparent
            ),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(
                    Font(
                        resource = "Ermilov.otf",
                        style = FontStyle.Normal,
                        weight = FontWeight.W100
                    )
                )
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(250.dp).background(
                Color(255, 164, 255).copy(alpha = 0.4f)
            )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                    if (selectedIndex == 1) {
                        changeGlobalCriteriaMatrix(criteria, TypeMinMax.MIN)
                    } else {
                        changeGlobalCriteriaMatrix(criteria, TypeMinMax.MAX)
                    }
                }) {
                    Text(text = s,style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(
                            Font(
                                resource = "Ermilov.otf",
                                style = FontStyle.Normal,
                                weight = FontWeight.Bold
                            )
                        )
                    ))
                }
            }
        }
    }
}

@Composable
fun RowScope.DropdownEvaluationCriteria(
    list:MutableList<String>,
    key:Int,
    criteria: CriteriaWithExpertEval
) {
    var expanded by remember { mutableStateOf(false) }
    var criteriaValue = 0
    for (i in list.indices){
        if(list[i]==criteria.values[key]){
            criteriaValue=i
        }
    }
    val items = list.toList()
    var selectedIndex by remember { mutableStateOf(criteriaValue) }
    Column(Modifier
        .border(1.dp, Color.Black)
        .weight(0.9f)
        .padding(2.dp)
        .width(100.dp)
        .height(60.dp),) {
        Text(
            items[selectedIndex],
            modifier = Modifier.fillMaxWidth().height(60.dp).padding(start = 7.dp, top = 4.dp)
                .clickable(onClick = { expanded = true }).background(
                    Color.Transparent
                ),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(
                    Font(
                        resource = "Ermilov.otf",
                        style = FontStyle.Normal,
                        weight = FontWeight.W100
                    )
                )
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp).background(
                Color(255, 164, 255).copy(alpha = 0.4f)
            )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                    updateMapEvaluation(key,criteria.name,list[selectedIndex])
                    println(GLOBAL_MATRIX_OF_CRITERIA_EVALUATION[0].values[1])
                }) {
                    Text(text = s,style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(
                            Font(
                                resource = "Ermilov.otf",
                                style = FontStyle.Normal,
                                weight = FontWeight.Bold
                            )
                        )
                    ))
                }
            }
        }
    }
}

@Composable
fun RowScope.DropdownChooseExpert(
    selectedIndex:Int,
    expanded:Boolean,
    changeValue:(Int)->Unit,
    onExpandedTrue:()->Unit,
    onExpandedFalse:()->Unit,
) {
    val list = getExpertsNames(GLOBAL_MATRIX_OF_EXPERTS)

    val items = list.toList()

    Column(Modifier
        .border(1.dp, Color.Black)
        .padding(2.dp)
        .width(100.dp)
        .height(60.dp),) {
        Text(
            items[selectedIndex],
            modifier = Modifier.fillMaxWidth().height(60.dp).padding(start = 7.dp, top = 4.dp)
                .clickable(onClick = onExpandedTrue).background(
                    Color.Transparent
                ),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(
                    Font(
                        resource = "Ermilov.otf",
                        style = FontStyle.Normal,
                        weight = FontWeight.W100
                    )
                )
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onExpandedFalse,
            modifier = Modifier.width(200.dp).background(
                Color(255, 164, 255).copy(alpha = 0.4f)
            )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    changeValue(index)
                }) {
                    Text(text = s,style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(
                            Font(
                                resource = "Ermilov.otf",
                                style = FontStyle.Normal,
                                weight = FontWeight.Bold
                            )
                        )
                    ))
                }
            }
        }
    }
}

@Composable
fun RowScope.DropdownAlternativeEvaluation(
    currentValue:String?,
    aIndex:Int,
    cKey:Int,
    indexOfExpertEvaluationList:Int,
    list:MutableList<String>
) {
    var expanded by remember { mutableStateOf(false) }
    var criteriaValue = 0
    for(i in list.indices){
        if(list[i]==currentValue){
            criteriaValue=i
        }
    }
    //println("BF SELECTED VALUE: $currentValue SELECTED INDEX: ${criteriaValue} VALUE BY INDEX ${list[criteriaValue]}")
    val items = list.toList()
    var selectedIndex by remember { mutableStateOf(criteriaValue) }
    //println("AFT SELECTED VALUE: $currentValue SELECTED INDEX: ${criteriaValue} VALUE BY INDEX ${items[selectedIndex]}")

    Column (Modifier
        .border(1.dp, Color.Black)
        .weight(0.9f)
        .padding(2.dp)
        .width(100.dp)
        .height(60.dp),){
        Text(
            items[selectedIndex],
            modifier = Modifier.fillMaxWidth().height(60.dp).padding(start = 7.dp, top = 4.dp)
                .clickable(onClick = { expanded = true }).background(
                    Color.Transparent
                ),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(
                    Font(
                        resource = "Ermilov.otf",
                        style = FontStyle.Normal,
                        weight = FontWeight.W100
                    )
                )
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp).background(
                Color(255, 164, 255).copy(alpha = 0.4f)
            )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                    println("aIndex: $aIndex, cKey: $cKey, selectedIndex:$selectedIndex")
                    println("items[selIndex]: ${items[selectedIndex]}")
                    println("indexOfExpertEvaluationList: $indexOfExpertEvaluationList")
                    println("GLOBAL_EXPERTS_EVALUATION_LIST[indexOfExpertEvaluationList]: ${GLOBAL_EXPERTS_EVALUATION_LIST[indexOfExpertEvaluationList]}")
                    println("GLOBAL_EXPERTS_EVALUATION_LIST[indexOfExpertEvaluationList].table: ${GLOBAL_EXPERTS_EVALUATION_LIST[indexOfExpertEvaluationList].table[aIndex][cKey]}")
                    GLOBAL_EXPERTS_EVALUATION_LIST[indexOfExpertEvaluationList].table[aIndex][cKey] = items[selectedIndex]

                }) {
                    Text(text = s,style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(
                            Font(
                                resource = "Ermilov.otf",
                                style = FontStyle.Normal,
                                weight = FontWeight.Bold
                            )
                        )
                    ))
                }
            }
        }
    }
}
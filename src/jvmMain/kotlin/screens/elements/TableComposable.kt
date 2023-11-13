package screens.elements

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.Criteria
import models.TypeMinMax
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
        fontSize = 16.sp,
        fontWeight = FontWeight(600)

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
            .height(30.dp),
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        fontWeight = FontWeight(600)

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
            .height(30.dp),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp
            ),


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
            .height(30.dp),
        textAlign = TextAlign.Center,
        fontSize = 12.sp
    )
}
@Composable
fun RowScope.DropdownDemo(
   criteria:Criteria
) {
    var expanded by remember { mutableStateOf(false) }
    val criteriaValue = if(criteria.type==TypeMinMax.MAX) 0 else 1
    val items = listOf(TypeMinMax.MAX.toString(), TypeMinMax.MIN.toString())
    var selectedIndex by remember { mutableStateOf(criteriaValue) }
        Column{
            Text(items[selectedIndex],modifier = Modifier.border(1.dp, Color.Black).width(250.dp).height(34.dp).padding(start = 7.dp,top=4.dp).clickable(onClick = { expanded = true }).background(
                Color.White))
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(250.dp).background(
                    Color.LightGray)
            ) {
                items.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedIndex = index
                        expanded = false
                        if(selectedIndex==1){
                            changeGlobalCriteriaMatrix(criteria,TypeMinMax.MIN)
                        }else{
                            changeGlobalCriteriaMatrix(criteria,TypeMinMax.MAX)
                        }
                    }) {
                        Text(text = s)
                    }
                }
            }
        }


}
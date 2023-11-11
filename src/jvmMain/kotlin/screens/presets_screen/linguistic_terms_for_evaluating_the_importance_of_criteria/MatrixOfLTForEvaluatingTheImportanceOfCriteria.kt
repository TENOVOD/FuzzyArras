package screens.presets_screen.linguistic_terms_for_evaluating_the_importance_of_criteria

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import models.LinguisticTermCell
import screens.elements.TableCell
import screens.presets_screen.GLOBAl_CRITERIA_LT
import screens.presets_screen.updateDataInList


@Composable
fun setMatrixOfLTForEvaluatingTheImportanceOfCriteria(
    fullName: String,
    shortName: String,
    firstLimit: String,
    secondLimit: String,
    thirdLimit: String,
    changeFullName: (String) -> Unit,
    changeShortName: (String) -> Unit,
    changeFirstLimit: (String) -> Unit,
    changeSecondLimit: (String) -> Unit,
    changeThirdLimit: (String) -> Unit,
) {
    Row {
        TableCell(fullName, onNewValue = changeFullName)
        TableCell(shortName) {
            changeShortName(it)
        }
        TableCell(firstLimit) { changeFirstLimit(it) }
        TableCell(secondLimit) { changeSecondLimit(it) }
        TableCell(thirdLimit) { changeThirdLimit(it) }
    }

}

@Composable
fun updateDataMatrix(
    data: MutableList<LinguisticTermCell>
) {
    data.forEach { el ->
        var remeFullName by remember { mutableStateOf(el.fullName) }
        var remeShortName by remember { mutableStateOf(el.shortName) }
        var remeFirstLimit by remember { mutableStateOf(el.firstLimit) }
        var remeSecondLimit by remember { mutableStateOf(el.secondLimit) }
        var remeThirdLimit by remember { mutableStateOf(el.thirdLimit) }

        setMatrixOfLTForEvaluatingTheImportanceOfCriteria(
            fullName = remeFullName,
            shortName = remeShortName,
            firstLimit = remeFirstLimit,
            secondLimit = remeSecondLimit,
            thirdLimit = remeThirdLimit,
            changeFullName = {
                val index = updateDataInList(data, oldFullName = remeFullName)
                println("INDEX=$index")
                remeFullName = it
                GLOBAl_CRITERIA_LT.set(
                    index,
                    LinguisticTermCell(remeFullName, remeShortName, remeFirstLimit, remeSecondLimit, remeThirdLimit)
                )
                println(GLOBAl_CRITERIA_LT)
            },
            changeShortName = {
                val index = updateDataInList(data, oldFullName = remeFullName)
                println("INDEX=$index")
                remeShortName = it
                GLOBAl_CRITERIA_LT.set(
                    index,
                    LinguisticTermCell(remeFullName, remeShortName, remeFirstLimit, remeSecondLimit, remeThirdLimit)
                )
                println(GLOBAl_CRITERIA_LT)
            },
            changeFirstLimit = {
                val index = updateDataInList(data, oldFullName = remeFullName)
                println("INDEX=$index")
                remeFirstLimit = it
                GLOBAl_CRITERIA_LT.set(
                    index,
                    LinguisticTermCell(remeFullName, remeShortName, remeFirstLimit, remeSecondLimit, remeThirdLimit)
                )
                println(GLOBAl_CRITERIA_LT)
            },
            changeSecondLimit = {
                val index = updateDataInList(data, oldFullName = remeFullName)
                println("INDEX=$index")
                remeSecondLimit = it
                GLOBAl_CRITERIA_LT.set(
                    index,
                    LinguisticTermCell(remeFullName, remeShortName, remeFirstLimit, remeSecondLimit, remeThirdLimit)
                )
                println(GLOBAl_CRITERIA_LT)
            },
            changeThirdLimit = {
                val index = updateDataInList(data, oldFullName = remeFullName)
                println("INDEX=$index")
                remeThirdLimit = it
                GLOBAl_CRITERIA_LT.set(
                    index,
                    LinguisticTermCell(remeFullName, remeShortName, remeFirstLimit, remeSecondLimit, remeThirdLimit)
                )
                println(GLOBAl_CRITERIA_LT)
            }

        )
    }
}

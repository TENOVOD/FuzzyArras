package screens.presets_screen.parts.сount_LT

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import screens.elements.Counter
import screens.elements.CounterWithoutText

@Composable
fun CountAlternativeLT(
    alternativeEvaluation: Int,
    onAddCounterAlternativeValue: (Int) -> Unit,
    onRemoveCounterAlternativeValue: (Int) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(size = 5.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.padding(15.dp)
            .background(Color(255, 153, 255).copy(alpha = 0.3f)),
        color = Color.Transparent
    ) {
        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Кількість ЛТ для оцінки альтернатив", style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(
                        Font(
                            resource = "Ermilov.otf",
                            style = FontStyle.Normal,
                            weight = FontWeight.W100
                        )
                    )
                ), modifier = Modifier.padding(end = 5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            CounterWithoutText(
                "", alternativeEvaluation,
                onAddCounterValue = onAddCounterAlternativeValue,
                onRemoveCounterValue = onRemoveCounterAlternativeValue
            )
        }
    }
}
@Composable
fun CountCriteriaLT(
    criteriaEvaluation: Int,

    onAddCounterCriteriaValue: (Int) -> Unit,
    onRemoveCounterCriteriaValue: (Int) -> Unit,

) {
    Surface(
        shape = RoundedCornerShape(size = 5.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.padding(15.dp)
            .background(Color(255, 153, 255).copy(alpha = 0.3f)),
        color = Color.Transparent
    ) {
        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Кількість ЛТ для оцінки критеріїв", style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(
                        Font(
                            resource = "Ermilov.otf",
                            style = FontStyle.Normal,
                            weight = FontWeight.W100
                        )
                    )
                ), modifier = Modifier.padding(end = 5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            CounterWithoutText(
                "", criteriaEvaluation,
                onAddCounterValue = onAddCounterCriteriaValue,
                onRemoveCounterValue = onRemoveCounterCriteriaValue
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}
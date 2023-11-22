package screens.presets_screen.alternative_count

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import screens.elements.BasicButton
import screens.elements.Counter

@Composable
fun AlternativeCountView(
    alternativeCount: Int,
    onAddCounterAlternativeValue: (Int) -> Unit,
    onRemoveCounterAlternativeValue: (Int) -> Unit,
    onAlternativeButtonAction: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(size = 5.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.width(400.dp).padding(15.dp).background(Color(255, 153, 255).copy(alpha = 0.3f)),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Альтернативи",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(
                        Font(
                            resource = "Ermilov.otf",
                            style = FontStyle.Normal,
                            weight = FontWeight.W100
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Counter(
                "Кількість: ", alternativeCount,
                onAddCounterValue = onAddCounterAlternativeValue,
                onRemoveCounterValue = onRemoveCounterAlternativeValue
            )
            Spacer(modifier = Modifier.height(5.dp))
            BasicButton("Змінити назви", action = onAlternativeButtonAction)
        }
    }
}
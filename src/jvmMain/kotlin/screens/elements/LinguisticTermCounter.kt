package screens.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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


@Composable
fun CounterWithoutText(
    name: String,
    counterValue: Int,
    onAddCounterValue: (Int) -> Unit,
    onRemoveCounterValue: (Int) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
            shape = RoundedCornerShape(size = 5.dp),

            color = Color.Transparent
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    modifier = Modifier
                        .width(50.dp)
                        .background(Color.Transparent)
                        .padding(start = 2.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(size = 35.dp),
                    colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor = Color(255, 153, 255),
                        contentColor = Color.Black,
                    ),
                    onClick = { onRemoveCounterValue(counterValue) }
                ) {
                    Text(
                        text = "—", style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(
                                Font(
                                    resource = "Ermilov.otf",
                                    style = FontStyle.Normal,
                                    weight = FontWeight.W100
                                )
                            )
                        ), textAlign = TextAlign.Center
                    )
                }

                Text(
                    modifier = Modifier.width(40.dp),
                    text = counterValue.toString(),
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
                    ),

                    )
                Button(
                    modifier = Modifier
                        .width(50.dp)
                        .background(Color.Transparent)
                        .padding(end = 2.dp),
                    shape = RoundedCornerShape(size = 35.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor = Color(255, 153, 255),
                        contentColor = Color.Black,
                    ),
                    onClick = { onAddCounterValue(counterValue) }
                ) {
                    Text(
                        text = "+", style = TextStyle(
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
                }
            }
        }
    }

}

@Composable
fun Counter(
    name: String,
    counterValue: Int,
    onAddCounterValue: (Int) -> Unit,
    onRemoveCounterValue: (Int) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
            shape = RoundedCornerShape(size = 5.dp),

            color = Color.Transparent
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    modifier = Modifier
                        .width(50.dp)
                        .background(Color.Transparent)
                        .padding(start = 2.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(size = 35.dp),
                    colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor = Color(255, 153, 255),
                        contentColor = Color.Black,
                    ),
                    onClick = { onRemoveCounterValue(counterValue) }
                ) {
                    Text(
                        text = "—", style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(
                                Font(
                                    resource = "Ermilov.otf",
                                    style = FontStyle.Normal,
                                    weight = FontWeight.W100
                                )
                            )
                        ), textAlign = TextAlign.Center
                    )
                }

                Text(
                    modifier = Modifier.width(40.dp),
                    text = counterValue.toString(),
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
                    ),

                    )
                Button(
                    modifier = Modifier
                        .width(50.dp)
                        .background(Color.Transparent)
                        .padding(end = 2.dp),
                    shape = RoundedCornerShape(size = 35.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors =
                    ButtonDefaults.buttonColors(
                        backgroundColor = Color(255, 153, 255),
                        contentColor = Color.Black,
                    ),
                    onClick = { onAddCounterValue(counterValue) }
                ) {
                    Text(
                        text = "+", style = TextStyle(
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
                }
            }
        }
    }

}
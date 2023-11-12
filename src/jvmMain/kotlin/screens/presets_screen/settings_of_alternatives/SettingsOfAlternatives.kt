package screens.presets_screen.settings_of_alternatives

import GLOBAL_COUNT_CRITERIA
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navcontroller.NavController


@Composable
fun SettingsOfAlternativesScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val countOfAlternative = GLOBAL_COUNT_CRITERIA



        Button(
            onClick = {
                navController.navigate(Screen.NotificationsScreen.name)
            }) {
            Text("Navigate to Notification")
        }
    }
}
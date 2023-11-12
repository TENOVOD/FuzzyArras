import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.setFor3LinguisticTerm
import models.Criteria
import models.LinguisticTermCell
import navcontroller.NavController
import navcontroller.NavigationHost
import navcontroller.composable
import navcontroller.rememberNavController
import screens.HomeScreen
import screens.NotificationScreen
import screens.ProfileScreen
import screens.SettingScreen
import screens.elements.Counter
import screens.presets_screen.PresentScreenView
import screens.presets_screen.settings_of_alternatives.SettingsOfAlternativesScreen
import test.CountArray
import test.JustTextEdit
import test.SuperChanger


var GLOBAl_CRITERIA_LT = setFor3LinguisticTerm
var GLOBAl_ALTERNATIVE_LT = setFor3LinguisticTerm

var GLOBAL_COUNT_EV_CRITERIA=3
var GLOBAL_COUNT_EV_ALTERNATIVE=3

var GLOBAL_COUNT_CRITERIA = 2
var GLOBAL_COUNT_ALTERNATIVE = 2
var GLOBAL_COUNT_EXPERT = 1

//var GLOBAL_MATRIX_OF_CRITERIA_LT= mutableListOf<Alternative>()
var GLOBAL_MATRIX_OF_ALTERNATIVE_LT= mutableListOf<Criteria>()
@Composable
@Preview
fun App() {
    
    //PresentScreenView()

    val screens = Screen.values().toList()
    val navController by rememberNavController(Screen.HomeScreen.name)
    val currentScreen by remember {
        navController.currentScreen
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.background(color = MaterialTheme.colors.background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                NavigationRail(
                    modifier = Modifier.align(Alignment.CenterStart).fillMaxHeight()
                ) {
                    screens.forEach {
                        NavigationRailItem(
                            selected = currentScreen == it.name,
                            icon = {
                                Icon(
                                    imageVector = it.icon,
                                    contentDescription = it.label
                                )
                            },
                            label = {
                                Text(it.label)
                            },
                            alwaysShowLabel = false,
                            onClick = {
                                navController.navigate(it.name)
                            }
                        )
                    }
                }

                Box(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    CustomNavigationHost(navController = navController)
                }
            }
        }
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {

        App()
    }
}

/**
 * Screens
 */
enum class Screen(
    val label: String,
    val icon: ImageVector
) {
    HomeScreen(
        label = "Settings",
        icon = Icons.Filled.Settings
    ),
    NotificationsScreen(
        label = "Ev.Crit.",
        icon = Icons.Filled.AddCircle
    ),
    SettingsScreen(
        label = "Ev.Altern.",
        icon = Icons.Filled.AddCircle
    ),
    ProfileScreens(
        label = "Result",
        icon = Icons.Filled.Done
    ),
    CriteriaSettings(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    )
}


@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screen.HomeScreen.name) {
            PresentScreenView(navController)
        }

        composable(Screen.NotificationsScreen.name) {
            NotificationScreen(navController)
        }

        composable(Screen.SettingsScreen.name) {
            SettingScreen(navController)
        }

        composable(Screen.ProfileScreens.name) {
            ProfileScreen(navController)
        }

        composable(Screen.CriteriaSettings.name){
            SettingsOfAlternativesScreen(navController)
        }


    }.build()
}
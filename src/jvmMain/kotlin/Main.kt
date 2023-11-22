import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.*
import models.*
import navcontroller.NavController
import navcontroller.NavigationHost
import navcontroller.composable
import navcontroller.rememberNavController
import screens.ResultScreen
import screens.evaluation_alternative.EvaluationAlternativeScreen
import screens.evaluation_alternative.addition_windows.*
import screens.evaluation_criteria.EvaluationCriteria
import screens.evaluation_criteria.criterion_evaluation_in_the_form_of_fuzzy_triangular_numbers.CriteriaEvalFuzzyTriangularNumbersScreen
import screens.evaluation_criteria.estimates_in_the_form_of_fuzzy_numbers_based_on_transformed_lexical_terms.EstimatesFormOfFuzzyNumbersTransformedLTScreen
import screens.presets_screen.PresentScreenView
import screens.presets_screen.alternatives_names.AlternativesName
import screens.presets_screen.expert_count.ExpertsName
import screens.presets_screen.settings_of_alternatives.SettingsOfAlternativesScreen
import java.io.File


var GLOBAl_CRITERIA_LT = setFor7LinguisticTerm
var GLOBAl_ALTERNATIVE_LT = setFor7AlternativeTerm

var GLOBAL_COUNT_EV_CRITERIA = 7
var GLOBAL_COUNT_EV_ALTERNATIVE = 7

var GLOBAL_COUNT_CRITERIA = 2
var GLOBAL_COUNT_ALTERNATIVE = 2
var GLOBAL_COUNT_EXPERT = 1

var GLOBAL_MATRIX_OF_CRITERIA = defaultListFor2Criteria
var GLOBAL_MATRIX_OF_ALTERNATIVES = setFor2Alternatives
var GLOBAL_MATRIX_OF_EXPERTS = setForExpert

//SECOND PAGE (EVALUATION CRITERIA)
var GLOBAL_MATRIX_OF_CRITERIA_EVALUATION = addNewCriteriaOrExpert(GLOBAL_COUNT_CRITERIA, GLOBAL_COUNT_EXPERT)
var GLOBAL_NORMALIZE_OF_CRITERIA_LT = mutableListOf<LinguisticTermCell>()
var GLOBAL_CRITERIA_FUZZY_NUMBERS = getEmptyCriteriaFuzzyNumbers()

//THIRD SCREEN (EVALUATION ALTERNATIVE)
var GLOBAL_EXPERTS_EVALUATION_LIST = setEmptyListExpertsEvaluation()
var SELECTED_EXPERT_INDEX = 0

var GLOBAL_AGGREGATE_SCORE = getEmptyAggregationStore()
var GLOBAL_NORMALIZE_OF_ALTERNATIVE_LT = mutableListOf<LinguisticTermCell>()
var GLOBAL_ALL_ALTERNATIVE_FUZZY_NUMBERS = mutableListOf<Pair<String, AlternativeAndCriteriaFuzzyNumbers>>()
var GLOBAL_ALTERNATIVE_FUZZY_NUMBERS_BY_CRITERIA_TYPE = mutableListOf<AlternativeAndCriteriaFuzzyNumbers>()

var GLOBAL_NORMALIZED_ALTERNATIVE_MATRIX = mutableListOf<Pair<String, AlternativeAndCriteriaFuzzyNumbers>>()
var GLOBAL_NORMALIZED_WEIGHTED_MATRIX = mutableListOf<Pair<String, AlternativeAndCriteriaFuzzyNumbers>>()

var GLOBAL_RESULT = mutableListOf<Pair<String, AlternativeAndCriteriaFuzzyNumbers>>()
var GLOBAL_S_VAlUES = mutableListOf<Pair<String, Array<Float>>>()

@Composable
@Preview
fun App() {

    //PresentScreenView()
    val prep = Screen.values().toList()
    val screens = prep.dropLast(11)
    val navController by rememberNavController(Screen.HomeScreen.name)
    val currentScreen by remember {
        navController.currentScreen
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.background(color = Color(255, 153, 255))
        ) {
            val file =
                File("D:\\TEST desktop Composable\\LAB2\\FuzzyAras\\FuzzyAras\\src\\jvmMain\\resources\\pow2.jpg")
            val imageBitmap: ImageBitmap = remember(file) {
                loadImageBitmap(file.inputStream())
            }
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = BitmapPainter(image = imageBitmap),
                contentDescription = null,
                alpha = 0.3F
            )
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                NavigationRail(
                    modifier = Modifier.background(color = Color(255, 153, 255)).align(Alignment.CenterStart).fillMaxHeight()
                ) {
                    screens.forEach {
                        NavigationRailItem(
                            selected = currentScreen == it.name,
                            icon = {
                                Icon(
                                    imageVector = it.icon,
                                    contentDescription = it.label,
                                    tint = Color.Black,
                                )
                            },
                            label = {
                                Text(
                                    it.label, style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(
                                            Font(
                                                resource = "Ermilov.otf",
                                                style = FontStyle.Normal,
                                                weight = FontWeight.W100
                                            )
                                        ),
                                        color = Color.Black
                                    )
                                )
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
    EvaluationCriteria(
        label = "Ev.Crit.",
        icon = Icons.Filled.AddCircle
    ),
    EvaluationAlternative(
        label = "Ev.Altern.",
        icon = Icons.Filled.AddCircle
    ),
    ResultScreen(
        label = "Result",
        icon = Icons.Filled.Done
    ),
    CriteriaSettings(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    AlternativesName(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    ExpertsName(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    FuzzyTriangularNumbers(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    EstimatesFormOfFuzzyNumbersTransformedLTScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    AggregateScoreScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    EstimatesInTheFormOfFuzzyTriangularNumbersScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    EstimatesInTheFormOfFuzzyNumberScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    OptimalCriteriaValuesScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    NormalizedMatrixScreen(
        label = "Criteria settings",
        icon = Icons.Filled.Done
    ),
    NormalizedWeightedMatrixScreen(
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

        composable(Screen.EvaluationCriteria.name) {
            EvaluationCriteria(navController)
        }

        composable(Screen.ResultScreen.name) {
            ResultScreen(navController)
        }

        composable(Screen.CriteriaSettings.name) {
            SettingsOfAlternativesScreen(navController)
        }
        composable(Screen.AlternativesName.name) {
            AlternativesName(navController)
        }
        composable(Screen.ExpertsName.name) {
            ExpertsName(navController)
        }
        composable(Screen.FuzzyTriangularNumbers.name) {
            CriteriaEvalFuzzyTriangularNumbersScreen(navController)
        }
        composable(Screen.EstimatesFormOfFuzzyNumbersTransformedLTScreen.name) {
            EstimatesFormOfFuzzyNumbersTransformedLTScreen(navController)
        }
        composable(Screen.EvaluationAlternative.name) {
            EvaluationAlternativeScreen(navController)
        }
        composable(Screen.AggregateScoreScreen.name) {
            AggregateScoreScreen(navController)
        }
        composable(Screen.EstimatesInTheFormOfFuzzyTriangularNumbersScreen.name) {
            EstimatesInTheFormOfFuzzyTriangularNumbersScreen(navController)
        }
        composable(Screen.EstimatesInTheFormOfFuzzyNumberScreen.name) {
            EstimatesInTheFormOfFuzzyNumber(navController)
        }
        composable(Screen.OptimalCriteriaValuesScreen.name) {
            OptimalCriteriaValuesScreen(navController)
        }
        composable(Screen.NormalizedMatrixScreen.name) {
            NormalizedMatrixScreen(navController)
        }
        composable(Screen.NormalizedWeightedMatrixScreen.name) {
            NormalizedWeightedMatrixScreen(navController)
        }

    }.build()
}
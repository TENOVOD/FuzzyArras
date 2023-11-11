import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.elements.Counter
import screens.presets_screen.PresentScreenView
import test.CountArray
import test.JustTextEdit
import test.SuperChanger


@Composable
@Preview
fun App() {

    PresentScreenView()



}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

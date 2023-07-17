import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demo.ui.theme.DemoTheme
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    // Greeting("Android Kotlin!")
                    TextInput()
                }
            }
        }
    }
}

@Composable
fun TextInput() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState,
        onValueChange = { newValue ->
            textState = newValue
            // Log.d("IGDROID", newValue.text) // Logging inside a composable function is not recommended.
        },
        label = { Text(text = "Write a Message") }
    )
}

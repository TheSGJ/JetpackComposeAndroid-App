package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitialTextField()
            SayTheWord("Example from Android Planet!")
        }
    }
}

@Composable
fun SayTheWord(name: String = "Android is Best") {
    Text(
        text = "Hello $name",
        fontWeight = FontWeight.ExtraBold,
        color = Color.Green,
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun InitialTextField() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
    )
}

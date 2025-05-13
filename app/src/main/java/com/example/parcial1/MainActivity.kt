package com.example.parcial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValidarNotaApp()
        }
    }
}

@Composable
fun ValidarNotaApp() {
    var notaText by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFADD8E6))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text("Parcial #1", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Alberto Rodriguez\nNathaly Sanchez", fontSize = 16.sp)

            Spacer(modifier = Modifier.height(24.dp))

            Text("Ingrese la nota a validar")

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = notaText,
                onValueChange = { notaText = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val nota = notaText.toIntOrNull()
                resultado = if (nota != null && nota in 0..100) {
                    when (nota) {
                        in 91..100 -> "A (Excelente)"
                        in 81..90 -> "B (Bueno)"
                        in 71..80 -> "C (Regular)"
                        in 61..70 -> "D (Más o menos regular)"
                        else -> "No Aprobado"
                    }
                } else {
                    "Ingrese una nota válida (0-100)"
                }
            }) {
                Text("Validar")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = resultado, fontSize = 20.sp)
        }
    }
}

package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer

@Composable
fun AddScreen(onClose: () -> Unit = {}) {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Input") })
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = { onClose() }) {
            Text("Simpan & Kembali")
        }
    }
}

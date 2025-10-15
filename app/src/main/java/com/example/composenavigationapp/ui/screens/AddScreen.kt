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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

//@Composable
//fun AddScreen(onClose: () -> Unit = {}) {
//    var text by remember { mutableStateOf("") }
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Input") })
//        Spacer(modifier = Modifier.padding(8.dp))
//        Button(onClick = { onClose() }) {
//            Text("Simpan & Kembali")
//        }
//    }
//}

@Composable
fun AddScreen(
    onAddNote: (Note) -> Unit,
    onClose: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Judul") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Isi Catatan") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            maxLines = 10
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (title.isNotBlank() && content.isNotBlank()) {
                onAddNote(Note(title = title, content = content))
                onClose()
            }
        }) {
            Text("Simpan & Kembali")
        }
    }
}

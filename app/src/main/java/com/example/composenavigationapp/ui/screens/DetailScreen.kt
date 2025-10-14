package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(itemId: Int) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Detail Screen")
        Text("Item ID: $itemId", modifier = Modifier.padding(top = 8.dp))
    }
}

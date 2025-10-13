package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onItemClick: (Int) -> Unit = {}, openDrawer: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        repeat(6) { i ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .clickable { onItemClick(i + 1) }
            ) {
                Text(text = "Item ${i + 1}", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

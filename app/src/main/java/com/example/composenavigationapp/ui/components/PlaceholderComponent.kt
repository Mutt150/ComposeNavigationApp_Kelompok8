package com.example.composenavigationapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * File: PlaceholderComponent.kt
 * Deskripsi: Contoh komponen UI sederhana (Composable kecil) untuk latihan struktur modular.
 */

@Composable
fun PlaceholderButtonComponent(
    label: String = "Klik Saya",
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onClick) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

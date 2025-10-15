package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composenavigationapp.ui.components.SettingDropdown
import com.example.composenavigationapp.ui.components.SettingSwitch

@Composable
fun SettingsScreen(
    isDarkTheme: Boolean,
    onToggleDarkTheme: (Boolean) -> Unit
) {
    var textSize by remember { mutableStateOf("Medium") }
    var showAboutDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🌙 DARK MODE
        SettingSwitch(
            title = "Dark Mode",
            checked = isDarkTheme,
            onCheckedChange = { onToggleDarkTheme(it) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔤 UKURAN TEKS
        SettingDropdown(
            title = "Ukuran Teks",
            options = listOf("Small", "Medium", "Large"),
            selected = textSize,
            onSelect = { textSize = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ℹ️ TENTANG APLIKASI
        Button(onClick = { showAboutDialog = true }) {
            Text("Tentang Aplikasi")
        }

        if (showAboutDialog) {
            AlertDialog(
                onDismissRequest = { showAboutDialog = false },
                title = { Text("Tentang Aplikasi") },
                text = {
                    Text("Version 1.0\nDibuat oleh: Nama Kamu\nKontak: email@example.com")
                },
                confirmButton = {
                    TextButton(onClick = { showAboutDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}



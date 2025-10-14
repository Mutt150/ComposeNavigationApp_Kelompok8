package com.example.composenavigationapp.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info

@Composable
fun DrawerContent(onNavigate: (String) -> Unit) {
    ModalDrawerSheet {
        Spacer(Modifier.height(12.dp))
        Text("Menu", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp))

        NavigationDrawerItem(
            label = { Text("About") },
            selected = false,
            onClick = { onNavigate(Routes.ABOUT) },
            icon = { Icon(Icons.Filled.Info, contentDescription = "About") }
        )

    }
}

package com.example.composenavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenavigationapp.ui.theme.ComposeNavigationAppTheme
import com.example.composenavigationapp.ui.navigation.RootNavGraph
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Bungkus dengan tema (otomatis dari folder theme)
            ComposeNavigationAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Buat NavController untuk navigasi antar layar
                    val navController = rememberNavController()
                    // Panggil RootNavGraph untuk handle semua rute
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}
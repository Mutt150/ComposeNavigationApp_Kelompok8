package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenavigationapp.R
import kotlinx.coroutines.delay

/**
 * File: SplashScreen.kt
 * Deskripsi:
 * Menampilkan logo aplikasi, teks judul, dan loading indicator selama 2 detik,
 * lalu otomatis navigasi ke HomeScreen.
 */

@Composable
fun SplashScreen(
    onFinished: () -> Unit,
    delayMillis: Long = 2000L
) {
    // Efek delay selama 2 detik sebelum pindah ke Home
    LaunchedEffect(Unit) {
        delay(delayMillis)
        onFinished()
    }

    // Tampilan utama Splash
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Logo aplikasi
            Image(
                painter = painterResource(id = R.drawable.kelompok_8_sakuin),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 16.dp)
            )

            // Teks judul aplikasi
            Text(
                text = "Compose Navigation App",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(Modifier.height(20.dp))

            // Loading indicator
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashPreview() {
    SplashScreen(onFinished = {})
}

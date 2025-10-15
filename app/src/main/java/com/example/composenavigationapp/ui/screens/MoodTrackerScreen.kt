package com.example.composenavigationapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodTrackerScreen(
    onDone: () -> Unit
) {
    val moods = listOf("😊", "😢", "😡", "😌", "😴", "🤯", "😇", "😎") // bisa ditambah
    val moodNames = listOf("Happy", "Sad", "Angry", "Calm", "Tired", "Stressed", "Blessed", "Cool")
    val motivations = mapOf(
        "Happy" to listOf("Keep that smile!", "Spread your joy today!", "Happiness is contagious 😄"),
        "Sad" to listOf("It’s okay to feel down sometimes.", "You’re stronger than you think.", "Better days are coming 🌈"),
        "Angry" to listOf("Take a deep breath.", "You can handle this calmly.", "Don’t let anger control you 💪"),
        "Calm" to listOf("Peace looks good on you.", "Keep your inner peace 🌿", "Stay grounded and focused."),
        "Tired" to listOf("Rest is productive too.", "You deserve a break 😴", "Recharge and come back stronger!"),
        "Stressed" to listOf("Take a short walk.", "Breathe in, breathe out.", "You got this! 💪"),
        "Blessed" to listOf("Count your blessings today 🙏", "Spread gratitude!", "Good vibes only ✨"),
        "Cool" to listOf("Keep being awesome 😎", "Stay confident!", "Rock your day!")
    )

    var selectedMood by rememberSaveable { mutableStateOf<String?>(null) }
    var motivationText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mood Tracker 😊") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Bagaimana perasaanmu hari ini?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))

            // LazyRow untuk scroll horizontal
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(moods.size) { index ->
                    val emoji = moods[index]
                    Button(
                        onClick = {
                            selectedMood = moodNames[index]
                            val list = motivations[moodNames[index]] ?: emptyList()
                            motivationText = list.random()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedMood == moodNames[index])
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(emoji, fontSize = 30.sp)
                    }
                }
            }

            Spacer(Modifier.height(32.dp))

            AnimatedVisibility(
                visible = selectedMood != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Kamu merasa: ${selectedMood ?: ""}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = motivationText,
                        fontSize = 16.sp,
                        lineHeight = 22.sp
                    )

                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { onDone() }
                    ) {
                        Text("Lanjut ke Home 👉")
                    }
                }
            }
        }
    }
}

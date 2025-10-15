package com.example.composenavigationapp.ui.navigation

import DetailScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composenavigationapp.ui.screens.*

@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RootNavGraph(
//    navController: NavHostController,
//    isDarkTheme: Boolean,                      // ✅ Tambahan
//    onToggleDarkTheme: (Boolean) -> Unit      // ✅ Tambahan
//) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    val isMainScreen = currentRoute?.startsWith(Routes.MAIN_GRAPH) == true ||
//            currentRoute in listOf(Routes.HOME, Routes.PROFILE, Routes.SETTINGS, Routes.ADD)
//
//    Scaffold(
//        bottomBar = {
//            if (isMainScreen) {
//                NavigationBar {
//                    NavigationBarItem(
//                        selected = currentRoute == Routes.HOME,
//                        onClick = {
//                            navController.navigate(Routes.HOME) {
//                                popUpTo(Routes.MAIN_GRAPH)
//                                launchSingleTop = true
//                            }
//                        },
//                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
//                        label = { Text("Home") }
//                    )
//                    NavigationBarItem(
//                        selected = currentRoute == Routes.PROFILE,
//                        onClick = {
//                            navController.navigate(Routes.PROFILE) {
//                                popUpTo(Routes.MAIN_GRAPH)
//                                launchSingleTop = true
//                            }
//                        },
//                        icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
//                        label = { Text("Profile") }
//                    )
//                    NavigationBarItem(
//                        selected = currentRoute == Routes.SETTINGS,
//                        onClick = {
//                            navController.navigate(Routes.SETTINGS) {
//                                popUpTo(Routes.MAIN_GRAPH)
//                                launchSingleTop = true
//                            }
//                        },
//                        icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
//                        label = { Text("Settings") }
//                    )
//                }
//            }
//        },
//        floatingActionButton = {
//            if (isMainScreen) {
//                FloatingActionButton(onClick = { navController.navigate(Routes.ADD) }) {
//                    Icon(Icons.Filled.Add, contentDescription = "Add")
//                }
//            }
//        }
//    ) { innerPadding ->
//        Box(modifier = Modifier.padding(innerPadding)) {
//            NavHost(
//                navController = navController,
//                startDestination = Routes.SPLASH
//            ) {
//                composable(Routes.SPLASH) {
//                    SplashScreen(
//                        onFinished = {
//                            navController.navigate(Routes.MOOD) {
//                                popUpTo(Routes.SPLASH) { inclusive = true }
//                                launchSingleTop = true
//                            }
//                        }
//                    )
//                }
//
//                composable(Routes.MOOD) {
//                    MoodTrackerScreen(
//                        onDone = {
//                            navController.navigate(Routes.MAIN_GRAPH) {
//                                popUpTo(Routes.MOOD) { inclusive = true }
//                                launchSingleTop = true
//                            }
//                        }
//                    )
//                }
//
//                navigation(startDestination = Routes.HOME, route = Routes.MAIN_GRAPH) {
//                    composable(Routes.HOME) {
//                        HomeScreen(
//                            navController = navController,
//                            onNavigateToMood = { navController.navigate(Routes.MOOD) }
//                        )
//                    }
//
//                    composable(Routes.PROFILE) { ProfileScreen() }
//
//                    // 🔥 Kirim state & fungsi dark mode ke SettingsScreen
//                    composable(Routes.SETTINGS) {
//                        SettingsScreen(
//                            isDarkTheme = isDarkTheme,
//                            onToggleDarkTheme = onToggleDarkTheme
//                        )
//                    }
//
//                    composable(Routes.ADD) { AddScreen(onClose = { navController.popBackStack() }) }
//                }
//            }
//        }
//    }
//}

@Composable
fun RootNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleDarkTheme: (Boolean) -> Unit
) {
    // State global notes
    val notes = remember { mutableStateListOf(
        Note(title = "Belanja Mingguan", content = "Beli telur, susu, roti"),
        Note(title = "Catatan Proyek", content = "Selesaikan modul 3 dan kirim revisi")
    )}

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isMainScreen = currentRoute?.startsWith(Routes.MAIN_GRAPH) == true ||
            currentRoute in listOf(Routes.HOME, Routes.PROFILE, Routes.SETTINGS, Routes.ADD)

    Scaffold(
        bottomBar = {
            if (isMainScreen) {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentRoute == Routes.HOME,
                        onClick = {
                            navController.navigate(Routes.HOME) {
                                popUpTo(Routes.MAIN_GRAPH)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == Routes.PROFILE,
                        onClick = {
                            navController.navigate(Routes.PROFILE) {
                                popUpTo(Routes.MAIN_GRAPH)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                        label = { Text("Profile") }
                    )
                    NavigationBarItem(
                        selected = currentRoute == Routes.SETTINGS,
                        onClick = {
                            navController.navigate(Routes.SETTINGS) {
                                popUpTo(Routes.MAIN_GRAPH)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                        label = { Text("Settings") }
                    )
                }
            }
        },
        floatingActionButton = {
            if (isMainScreen) {
                FloatingActionButton(onClick = { navController.navigate(Routes.ADD) }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Routes.SPLASH
            ) {
                // Splash Screen
                composable(Routes.SPLASH) {
                    SplashScreen(
                        onFinished = {
                            navController.navigate(Routes.MOOD) {
                                popUpTo(Routes.SPLASH) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }

                // Mood Tracker Screen
                composable(Routes.MOOD) {
                    MoodTrackerScreen(
                        onDone = {
                            navController.navigate(Routes.MAIN_GRAPH) {
                                popUpTo(Routes.MOOD) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }

                // Main Graph (Home, Profile, Settings, Add, Detail)
                navigation(startDestination = Routes.HOME, route = Routes.MAIN_GRAPH) {
                    composable(Routes.HOME) {
                        HomeScreen(navController = navController, notes = notes)
                    }

                    composable(Routes.PROFILE) {
                        ProfileScreen()
                    }

                    composable(Routes.SETTINGS) {
                        SettingsScreen(
                            isDarkTheme = isDarkTheme,
                            onToggleDarkTheme = onToggleDarkTheme
                        )
                    }

                    composable(Routes.ADD) {
                        AddScreen(
                            onAddNote = { newNote -> notes.add(newNote) },
                            onClose = { navController.popBackStack() }
                        )
                    }

                    composable(
                        route = "${Routes.DETAIL}/{noteId}",
                        arguments = listOf(navArgument("noteId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val noteId = backStackEntry.arguments?.getString("noteId")
                        val note = notes.find { it.id == noteId }
                        DetailScreen(navController = navController, note = note)
                    }
                }
            }
        }
    }
}

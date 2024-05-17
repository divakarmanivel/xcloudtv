package com.divakar.xcloudtv

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.divakar.xcloudtv.screens.GameScreen
import com.divakar.xcloudtv.screens.HomeScreen

@Composable
fun NavigationGraph(
    onThemeColorModeClick: () -> Unit,
    onLocaleChangeClick: () -> Unit,
    currentLocale: String
) {
    val navHostController = LocalNavController.current
    NavHost(navController = navHostController, startDestination = "home") {
        composable(
            route = "home"
        ) {
            HomeScreen(onThemeColorModeClick, onLocaleChangeClick)
        }
        composable(
            route = "game",
        ) {
            GameScreen(currentLocale)
        }
    }
}

val LocalNavController = compositionLocalOf<NavHostController> {
    throw Error("This should not be reached")
}

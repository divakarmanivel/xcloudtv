package com.divakar.xcloudtv

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

enum class Mode(val value: String) {
    Light("light"),
    Dark("dark")
}

data class ThemeMode(
    val mode: Mode,
    val title: String,
    val icon: Int
)

val themeModes = listOf(
    ThemeMode(mode = Mode.Dark, title = "Dark", icon = R.drawable.ic_dark_theme),
    ThemeMode(mode = Mode.Light, title = "Light", icon = R.drawable.ic_light_theme),
)

val LocalMode = compositionLocalOf { Mode.Dark }
val LocalThemeSeedColor = compositionLocalOf { GreenSeedColor }

data class SeedColor(val name: String, val color: Color)

val GreenSeedColor = SeedColor(name = "Default", color = Color(0xFF107C10))
val PurpleSeedColor = SeedColor(name = "Purple", color = Color(0xFF5E44D3))
val BlueSeedColor = SeedColor(name = "Aegean", color = Color(0xFF004A77))
val RedSeedColor = SeedColor(name = "Rosewood", color = Color(0xFF9C4146))
val YellowSeedColor = SeedColor(name = "Dijan", color = Color(0xFF616200))

val seedColors = listOf(
    GreenSeedColor,
    PurpleSeedColor,
    BlueSeedColor,
    RedSeedColor,
    YellowSeedColor
)
package com.divakar.xcloudtv

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.LayoutDirection
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import com.divakar.xcloudtv.colorutils.Scheme.Companion.dark
import com.divakar.xcloudtv.colorutils.Scheme.Companion.light
import com.divakar.xcloudtv.colorutils.toColorScheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun App() {
    var locale by remember { mutableStateOf(locales[0]) }
    var themeMode by remember { mutableStateOf(Mode.Dark) }
    var seedColor by remember { mutableStateOf(GreenSeedColor) }
    var isThemeSelectorExpanded by remember { mutableStateOf(false) }
    var isLocaleSelectorExpanded by remember { mutableStateOf(false) }

    val layoutDirection by remember { mutableStateOf(LayoutDirection.Ltr) }
    val fontScale by remember { mutableFloatStateOf(1.0f) }

    val argbColor = seedColor.color.toArgb()
    val colorScheme = if (themeMode == Mode.Dark) dark(argbColor) else light(argbColor)

    AppProviders(
        seedColor = seedColor,
        themeMode = themeMode,
        locale = locale,
        layoutDirection = layoutDirection,
        fontScale = fontScale,
    ) {
        MaterialTheme(colorScheme = colorScheme.toColorScheme()) {
            ThemeAndColorModeSelector(
                isExpanded = isThemeSelectorExpanded,
                onClose = { isThemeSelectorExpanded = false },
                onSeedColorChange = { seedColor = it },
                onThemeModeChange = { themeMode = it },
            ) {
                LocaleSelector(
                    isExpanded = isLocaleSelectorExpanded,
                    onClose = { isLocaleSelectorExpanded = false },
                    onLocaleChange = { locale = it }
                ) {
                    Surface(
                        Modifier.fillMaxSize(),
                        shape = RectangleShape
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            NavigationGraph(
                                onThemeColorModeClick = {
                                    isThemeSelectorExpanded = true
                                },
                                onLocaleChangeClick = {
                                    isLocaleSelectorExpanded = true
                                },
                                currentLocale = locale
                            )
                        }
                    }
                }
            }
        }
    }
}
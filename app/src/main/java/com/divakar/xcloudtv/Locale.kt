package com.divakar.xcloudtv

import androidx.compose.runtime.compositionLocalOf

val locales = listOf(
    "en-US",
    "en-CA",
    "de-DE",
    "es-ES",
    "es-AR",
    "fr-FR",
    "it-IT",
    "ja-JP",
    "ko-KR",
    "pl-PL",
    "pt-PT",
    "pt-BR",
)

val LocalLocale = compositionLocalOf { locales[0] }
package com.finora.personalfinance.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DompetKuColorScheme = lightColorScheme(
    primary = Ink,
    onPrimary = Color.White,
    secondary = Accent,
    onSecondary = Color.White,
    secondaryContainer = AccentSoft,
    onSecondaryContainer = Accent,
    tertiary = Accent,
    background = Paper,
    surface = CardBg,
    onSurface = Ink,
    surfaceVariant = Paper,
    onSurfaceVariant = Ink,
    surfaceContainer = CardBg,
    surfaceContainerHigh = CardBg,
    surfaceContainerHighest = CardBg,
    surfaceContainerLow = Paper,
    surfaceContainerLowest = CardBg,
    outline = Color(0xFFE5E5EA)
)

@Composable
fun DompetKuTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DompetKuColorScheme,
        content = content
    )
}

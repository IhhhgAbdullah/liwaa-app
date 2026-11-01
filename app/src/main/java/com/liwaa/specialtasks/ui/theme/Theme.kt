package com.liwaa.specialtasks.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val LiwaaColors = darkColorScheme(
    primary = LiwaaGold,
    onPrimary = LiwaaBlack,
    secondary = LiwaaRed,
    onSecondary = LiwaaWhite,
    background = LiwaaBlack,
    onBackground = LiwaaWhite,
    surface = LiwaaSurface,
    onSurface = LiwaaWhite,
    surfaceVariant = LiwaaSurface,
    onSurfaceVariant = LiwaaMuted,
    error = LiwaaRed
)

@Composable
fun LiwaaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LiwaaColors,
        content = content
    )
}

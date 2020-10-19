package com.airatlovesmusic.compose.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

val lightThemeColors = lightColors(
    primary = Color.Blue,
    primaryVariant = Color.Blue,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color.Red,
    onError = Color.White
)

fun shapes() = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = lightThemeColors,
        shapes = shapes(),
        content = content
    )
}

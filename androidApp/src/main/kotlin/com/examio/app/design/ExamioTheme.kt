package com.examio.app.design

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ExamioLightColors: ColorScheme = lightColorScheme(
    primary = Color(0xFFCC785C),
    onPrimary = Color.White,
    background = Color(0xFFFAF9F5),
    onBackground = Color(0xFF141413),
    surface = Color(0xFFFAF9F5),
    onSurface = Color(0xFF141413),
    surfaceVariant = Color(0xFFEFE9DE),
    onSurfaceVariant = Color(0xFF3D3D3A),
    error = Color(0xFFC64545),
)

@Composable
fun ExamioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ExamioLightColors,
        content = content,
    )
}

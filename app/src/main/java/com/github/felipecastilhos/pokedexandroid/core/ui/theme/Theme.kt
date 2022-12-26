package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.*

@Composable
fun PokedexAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ColorScheme = LocalColorTheme.current.colors,
    content: @Composable () -> Unit
) {
    val currentTheme = LocalColorTheme.current


    MaterialTheme(
        colors = colors.toColors(darkTheme),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

var LocalColorTheme = compositionLocalOf {
    ColorTheme.regular.lightMode
}


@Composable
fun changeTheme(isDarkTheme: Boolean): ColorTheme {
    return if (isDarkTheme) {
        ColorTheme.regular.darkMode
    } else {
        ColorTheme.regular.lightMode
    }
}


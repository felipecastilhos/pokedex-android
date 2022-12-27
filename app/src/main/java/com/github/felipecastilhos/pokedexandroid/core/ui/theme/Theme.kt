package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.github.felipecastilhos.pokedexandroid.features.pokemon.changeColorSchema

object PokedexTheme {
    inline val colors: ColorScheme
    @Composable get() =  LocalColors.current

    val LocalColors = compositionLocalOf {
        ColorScheme.regularLightModeColorSchema()
    }
}

@Composable
fun PokedexAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ColorScheme = PokedexTheme.colors,
    content: @Composable () -> Unit
) {
    val schema = changeColorSchema(isDarkTheme = darkTheme)
    CompositionLocalProvider( PokedexTheme.LocalColors provides schema) {
            MaterialTheme(
                colors = colors.toColors(darkTheme),
                typography = Typography,
                shapes = Shapes,
                content = content
            )
        }
}

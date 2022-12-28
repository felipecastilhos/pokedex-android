package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.github.felipecastilhos.pokedexandroid.features.pokemon.changeColorSchema
import kotlin.text.Typography

object PokedexTheme {
    inline val colors: ColorScheme
        @Composable get() = LocalColors.current

    inline val typography: PokedexTypographyScheme
        @Composable get() = LocalTypography.current

    inline val icons: IconScheme
        @Composable get() = LocalIcons.current

    val LocalColors = compositionLocalOf {
        ColorScheme.regularLightModeColorSchema()
    }

    val LocalTypography = compositionLocalOf {
        PokedexTypographyScheme
    }

    val LocalIcons = compositionLocalOf {
        IconScheme()
    }
}

@Composable
fun PokedexAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ColorScheme = PokedexTheme.colors,
    typographyScheme: PokedexTypographyScheme = PokedexTheme.typography,
    iconScheme: IconScheme = PokedexTheme.icons,
    content: @Composable () -> Unit
) {
    val schema = changeColorSchema(isDarkTheme = darkTheme)
    CompositionLocalProvider(PokedexTheme.LocalColors provides schema) {
        MaterialTheme(
            colors = colors.toColors(darkTheme),
            typography = MaterialTypography,
            shapes = Shapes,
            content = content
        )
    }
}

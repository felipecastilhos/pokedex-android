package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.github.felipecastilhos.pokedexandroid.features.pokemon.changeColorSchema

object PokedexTheme {
    inline val colors: ColorScheme
        @Composable get() = LocalColors.current

    inline val typography: PokedexTypographyScheme
        @Composable get() = LocalTypography.current

    inline val icons: IconScheme
        @Composable get() = LocalIcons.current

    inline val spacings: Spacing
        @Composable get() = LocalSpacings.current

    inline val radius: Radius
        @Composable get() = LocalRadius.current

    val LocalColors = compositionLocalOf {
        ColorScheme.regularLightModeColorSchema()
    }

    val LocalTypography = compositionLocalOf {
        PokedexTypographyScheme.default()
    }

    val LocalIcons = compositionLocalOf {
        IconScheme()
    }

    val LocalSpacings = compositionLocalOf {
        Spacing.regular()
    }

    val LocalRadius = compositionLocalOf {
        Radius.regular()
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
    CompositionLocalProvider(
        PokedexTheme.LocalColors provides schema,
        PokedexTheme.LocalIcons provides iconScheme,
        PokedexTheme.LocalTypography provides typographyScheme
    ) {
        MaterialTheme(
            colors = colors.toMaterialColors(darkTheme),
            typography = typographyScheme.toMaterialTypography(),
            shapes = Shapes,
            content = content
        )
    }
}

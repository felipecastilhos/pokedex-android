package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

class ColorScheme(
    var background: BackgroundColorGroup,
    var content: ContentColorGroup,
    var pokemonType: PokemonTypeColorGroup
) {
    internal companion object {
        fun regularLightModeColorSchema() = ColorScheme(
            background = BackgroundColorGroup.regular.lightMode,
            content = ContentColorGroup.regular.lightMode,
            pokemonType = PokemonTypeColorGroup.regular.lightMode
        )

        fun regularDarkModeColorSchema() = ColorScheme(
            background = BackgroundColorGroup.regular.darkMode,
            content = ContentColorGroup.regular.darkMode,
            pokemonType = PokemonTypeColorGroup.regular.darkMode
        )
    }
}

interface ColorGroup<T> {
    val regular: ColorMode<T>
}

interface ColorMode<T> {
    val lightMode: T
    val darkMode: T
}

data class ContentColorGroup(val primary: Color, val overSurface: Color) {
    internal companion object : ColorGroup<ContentColorGroup> {
        override val regular: ColorMode<ContentColorGroup>
            get() = object : ColorMode<ContentColorGroup> {
                override val lightMode: ContentColorGroup
                    get() = ContentColorGroup(
                        primary = GrayscalePalette.defaultPalette().darkGray,
                        overSurface = GrayscalePalette.defaultPalette().white
                    )
                override val darkMode: ContentColorGroup
                    get() = ContentColorGroup(
                        primary = GrayscalePalette.defaultPalette().white,
                        overSurface = GrayscalePalette.defaultPalette().lightGray
                    )
            }
    }
}

data class BackgroundColorGroup(val primary: Color, val surface: Color) {
    internal companion object : ColorGroup<BackgroundColorGroup> {
        override val regular: ColorMode<BackgroundColorGroup>
            get() = object : ColorMode<BackgroundColorGroup> {
                override val lightMode: BackgroundColorGroup
                    get() = BackgroundColorGroup(
                        primary = GrayscalePalette.defaultPalette().background,
                        surface = GrayscalePalette.defaultPalette().white
                    )
                override val darkMode: BackgroundColorGroup
                    get() = BackgroundColorGroup(
                        primary = GrayscalePalette.defaultPalette().darkGray,
                        surface = GrayscalePalette.defaultPalette().mediumGray
                    )
            }
    }
}

data class PokemonTypeColorGroup(
    val rock: Color,
    val ghost: Color,
    val steel: Color,
    val water: Color,
    val grass: Color,
    val psychic: Color,
    val ice: Color,
    val dark: Color,
    val fairy: Color,
    val normal: Color,
    val fighting: Color,
    val flying: Color,
    val poison: Color,
    val ground: Color,
    val bug: Color,
    val fire: Color,
    val eletric: Color,
    val dragon: Color
) {
    internal companion object : ColorGroup<PokemonTypeColorGroup> {
        override val regular: ColorMode<PokemonTypeColorGroup> =
            object : ColorMode<PokemonTypeColorGroup> {
                override val lightMode: PokemonTypeColorGroup = PokemonTypeColorGroup(
                    rock = Color(0xFFB69E31),
                    ghost = Color(0xFF70559B),
                    steel = Color(0xFFB7B9D0),
                    water = Color(0xFF6493EB),
                    grass = Color(0xFF74CB48),
                    psychic = Color(0xFFFB5584),
                    ice = Color(0xFF9AD6DF),
                    dark = Color(0xFF75574C),
                    fairy = Color(0xFFE69EAC),
                    normal = Color(0xFFAAA67F),
                    fighting = Color(0xFFC12239),
                    flying = Color(0xFFA891EC),
                    poison = Color(0xFFA43E9E),
                    ground = Color(0xFFDEC16b),
                    bug = Color(0xFFA7B723),
                    fire = Color(0xFFF57D31),
                    eletric = Color(0xFFF9CF30),
                    dragon = Color(0xFF7037FF)
                )

                //TODO: Create dark colors
                override val darkMode: PokemonTypeColorGroup = PokemonTypeColorGroup(
                    rock = Color(0xFFB69E31),
                    ghost = Color(0xFF70559B),
                    steel = Color(0xFFB7B9D0),
                    water = Color(0xFF6493EB),
                    grass = Color(0xFF74CB48),
                    psychic = Color(0xFFFB5584),
                    ice = Color(0xFF70559B),
                    dark = Color(0xFF75574C),
                    fairy = Color(0xFFE69EAC),
                    normal = Color(0xFFAAA67F),
                    fighting = Color(0xFFC12239),
                    flying = Color(0xFFA891EC),
                    poison = Color(0xFFA43E9E),
                    ground = Color(0xFFDEC16b),
                    bug = Color(0xFFA7B723),
                    fire = Color(0xFFF57D31),
                    eletric = Color(0xFFF9CF30),
                    dragon = Color(0xFF7037FF)
                )
            }
    }
}

fun ColorScheme.toMaterialColors(isDarkMode: Boolean): Colors {
    return if (isDarkMode) {
        darkColors(
            primary = pokemonType.ice,
            primaryVariant = pokemonType.rock,
            secondary = pokemonType.dragon,
            surface = background.surface,
            background = background.primary
        )
    } else {
        lightColors(
            primary = pokemonType.ice,
            primaryVariant = pokemonType.ghost,
            secondary = pokemonType.dragon,
            background = background.primary,
            surface = background.surface
        )
    }
}

open class GrayscalePalette(
    val darkGray: Color,
    val mediumGray: Color,
    val lightGray: Color,
    val white: Color,
    val background: Color
) {
    companion object {
        fun defaultPalette() = GrayscalePalette(
            darkGray = Color(0xFF212121),
            mediumGray = Color(0xFF666666),
            lightGray = Color(0xFFE0E0E0),
            white = Color(0xFFFFFFFF),
            background = Color(0xFFF7F7F7)
        )
    }
}



package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * ColorScheme represents the system of all color context group handled by the application.
 *
 * To create a light set of colors using the baseline values, use regularLightModeColorSchema To create a dark set of colors using the baseline values, use regularDarkModeColorSchema
 *
 * @param background contains all background color context
 * @param content contains colors to be used for content
 * @param pokemonType contains colors of pokemon types
 */
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

/**
 * [ColorGroup] is a interface of contexts that an group of color need to represent inside the application
 */
interface ColorGroup<T> {
    val regular: ColorMode<T>
}

/**
 * [ColorMode] represents all modes a group need to implement to work with the design system language
 */
interface ColorMode<T> {
    val lightMode: T
    val darkMode: T
}

/**
 * [ContentColorGroup] contains colors to be used for contents, like Texts and Icons.
 *
 * @param primary is the most often used color for contents. Use this as default for majority of texts, has high contrast with the primary background color.
 * @param overSurface is used to tint content that are displayed over an surface, like Badges and colored background layouts.
 */
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

/**
 * [BackgroundColorGroup] contains colors for background of the application.
 *
 * @param primary used often to tint background of the screen
 * @param surface used to tint things to create effect that they are above the primary surface
 */
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

/**
 * [PokemonTypeColorGroup] contains colors of Pokémon types. Use this to indicate what type is the Skill or Pokemon
 */
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

/**
 * Transform the Pokedex Color Scheme to the Material Design Color Scheme.
 */
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

/**
 * The Grayscale palette used for the Colors groups.
 */
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
/**
 * CompositionLocal used to pass [Colors] down the tree.
 *
 * Setting the value here is typically done as part of [PokedexTheme], which will
 * automatically handle efficiently updating any changed radius values without causing unnecessary
 * recompositions..
 * To retrieve the current value of this CompositionLocal, use [PokedexTheme.colors].
 */
val LocalColors = compositionLocalOf {
    ColorScheme.regularLightModeColorSchema()
}

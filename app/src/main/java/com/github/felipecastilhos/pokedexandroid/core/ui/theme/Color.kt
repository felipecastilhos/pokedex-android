package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

class ColorTheme(val colors: ColorScheme) {
    internal companion object : ColorGroup<ColorTheme> {
        override val regular: ColorMode<ColorTheme> = object : ColorMode<ColorTheme> {
            override val lightMode: ColorTheme = ColorTheme(ColorScheme(PokemonTypeColorGroup.regular.lightMode))
            override val darkMode: ColorTheme = ColorTheme(ColorScheme(PokemonTypeColorGroup.regular.darkMode))
        }
    }
}

class ColorScheme(var pokemonType: PokemonTypeColorGroup)

interface ColorGroup<T> {
    val regular: ColorMode<T>
}

interface ColorMode<T> {
    val lightMode: T
    val darkMode: T
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
        override val regular: ColorMode<PokemonTypeColorGroup> = object : ColorMode<PokemonTypeColorGroup> {
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

fun ColorScheme.toColors(isDarkMode: Boolean): Colors {
    return if (isDarkMode) {
        darkColors(
            primary = pokemonType.ice,
            primaryVariant = pokemonType.rock,
            secondary = pokemonType.dragon
        )
    } else {
        lightColors(
            primary = pokemonType.ice,
            primaryVariant = pokemonType.ghost,
            secondary = pokemonType.dragon
        )
    }
}



package com.github.felipecastilhos.pokedexandroid.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Pokemon", group = "Atoms - Colors")
@Composable
fun ColorsPokemonTypeShowkase() {
    PokedexAndroidTheme {
        Column {
            ColorPaletteViewer(pokemonTypeColorsToArray())
        }
    }
}

@Preview(name = "Background", group = "Atoms - Colors")
@Composable
fun ColorsBackgroundShowcase() {
    PokedexAndroidTheme {
        Column {
            ColorPaletteViewer(backgroundColorsToArray())
        }
    }
}

@Preview(name = "Content", group = "Atoms - Colors")
@Composable
fun ColorsContentShowcase() {
    PokedexAndroidTheme {
        Column {
            ColorPaletteViewer(contentColorsToArray())
        }
    }
}

@Composable
private fun ColorPaletteViewer(colorList: List<Pair<String, Color>>) {
    colorList.forEach { colorSpec ->
        ColorInfo(title = colorSpec.first, color = colorSpec.second)
    }
}

@Composable
private fun ColorInfo(title: String, color: Color) {
    Row {
        ColorBox(color = color)
        Spacer(modifier = Modifier.size(width = 8.dp, height = 0.dp))
        Text(text = title, fontSize = 16.sp)
    }
}


@Composable
private fun ColorBox(color: Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(color)
    )
}

@Composable
private fun pokemonTypeColorsToArray(): MutableList<Pair<String, Color>> {
    val colorList = mutableListOf<Pair<String, Color>>()
    colorList.add(Pair("ice", PokedexTheme.colors.pokemonType.ice))
    colorList.add(Pair("rock", PokedexTheme.colors.pokemonType.rock))
    colorList.add(Pair("ghost", PokedexTheme.colors.pokemonType.ghost))
    colorList.add(Pair("steel", PokedexTheme.colors.pokemonType.steel))
    colorList.add(Pair("water", PokedexTheme.colors.pokemonType.water))
    colorList.add(Pair("grass", PokedexTheme.colors.pokemonType.grass))
    colorList.add(Pair("psychic", PokedexTheme.colors.pokemonType.psychic))
    colorList.add(Pair("ice", PokedexTheme.colors.pokemonType.ice))
    colorList.add(Pair("dark", PokedexTheme.colors.pokemonType.dark))
    colorList.add(Pair("fairy", PokedexTheme.colors.pokemonType.fairy))
    colorList.add(Pair("normal", PokedexTheme.colors.pokemonType.normal))
    colorList.add(Pair("fighting", PokedexTheme.colors.pokemonType.fighting))
    colorList.add(Pair("flying", PokedexTheme.colors.pokemonType.flying))
    colorList.add(Pair("poison", PokedexTheme.colors.pokemonType.poison))
    colorList.add(Pair("ground", PokedexTheme.colors.pokemonType.ground))
    colorList.add(Pair("bug", PokedexTheme.colors.pokemonType.bug))
    colorList.add(Pair("fire", PokedexTheme.colors.pokemonType.fire))
    colorList.add(Pair("eletric", PokedexTheme.colors.pokemonType.eletric))
    colorList.add(Pair("dragon", PokedexTheme.colors.pokemonType.dragon))

    return colorList
}

@Composable
private fun backgroundColorsToArray(): MutableList<Pair<String, Color>> {
    val colorList = mutableListOf<Pair<String, Color>>()
    colorList.add(Pair("primary", PokedexTheme.colors.background.primary))
    colorList.add(Pair("surface", PokedexTheme.colors.background.surface))

    return colorList
}

@Composable
private fun contentColorsToArray(): MutableList<Pair<String, Color>> {
    val colorList = mutableListOf<Pair<String, Color>>()
    colorList.add(Pair("primary", PokedexTheme.colors.content.primary))
    colorList.add(Pair("overSurface", PokedexTheme.colors.content.overSurface))

    return colorList
}
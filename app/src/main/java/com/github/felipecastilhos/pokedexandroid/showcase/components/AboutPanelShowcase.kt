package com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.uicatalog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components.AboutPanelIconInfo
import com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components.AboutPanelLayout
import com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components.AboutPanelListInfo

@Preview(name = "About panel", group = "About Panel")
@Composable
fun AboutPanelPreview() {
    PokedexAndroidTheme {
        AboutPanelLayout(startSlot = {
            AboutPanelIconInfo(
                iconLabelPainter = painterResource(id = PokedexTheme.icons.weight),
                textLabel = "8,5 kg",
                informationTitle = "Weight",
                iconColor = PokedexTheme.colors.content.primary
            )
        }, middleSlot = {
            AboutPanelIconInfo(
                iconLabelPainter = painterResource(id = PokedexTheme.icons.ruler),
                textLabel = "0,7 m",
                informationTitle = "Height",
                iconColor = PokedexTheme.colors.content.primary
            )
        }, endSlot = {
            AboutPanelListInfo(
                infoList = mutableListOf("Chlorophyll", "Overgrow"),
                informationTitle = "Moves",
            )
        })
    }
}
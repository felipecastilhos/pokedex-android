package com.github.felipecastilhos.pokedexandroid.uicatalog.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BaseStatsTable
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BaseStatsTableEntry
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Base Stats", group = "Table")
@Composable
fun BaseStatsTablePreview() {
    PokedexAndroidTheme {
        BaseStatsTable(
            stats = mockStatsTableEntries(),
            barColor = PokedexTheme.colors.pokemonType.psychic
        )
    }
}


private fun mockStatsTableEntries(): MutableList<BaseStatsTableEntry> {
    return mutableListOf(
        BaseStatsTableEntry("HP", 0.45F),
        BaseStatsTableEntry("ATK", 0.49F),
        BaseStatsTableEntry("DEF", 0.49F),
        BaseStatsTableEntry("SATK", 0.65F),
        BaseStatsTableEntry("SDEF", 0.65F),
        BaseStatsTableEntry("SPD", 0.45F),
    )
}



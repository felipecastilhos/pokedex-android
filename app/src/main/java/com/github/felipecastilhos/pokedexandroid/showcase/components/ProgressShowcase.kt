package com.github.felipecastilhos.pokedexandroid.showcase.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.core.ui.components.ProgressBar
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Default", group = "Progress Bar")
@Composable
fun ProgressBarDefaultShowcase() {
    PokedexAndroidTheme {
        ProgressBar(progress = 4F)
    }
}

@Preview(name = "Color", group = "Progress Bar")
@Composable
fun ProgressBarColorShowcase() {
    PokedexAndroidTheme {
        ProgressBar(
            progress = 0.75F,
            color = PokedexTheme.colors.pokemonType.psychic,
            backgroundColor = PokedexTheme.colors.pokemonType.ghost
        )
    }
}

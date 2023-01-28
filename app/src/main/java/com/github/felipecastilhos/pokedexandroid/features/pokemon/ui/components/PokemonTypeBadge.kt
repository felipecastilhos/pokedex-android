package com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TextBadge
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.PokemonType

@Composable
fun PokemonTypeBadge(modifier: Modifier = Modifier, type: PokemonType) {
    TextBadge(
        modifier = modifier,
        text = type.name.lowercase().capitalize(),
        backgroundColor = type.color()
    )
}

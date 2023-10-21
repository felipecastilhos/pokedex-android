package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TextBadge
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonType
import java.util.*

@Composable
fun PokemonTypeBadge(type: PokemonType, modifier: Modifier = Modifier) {
    TextBadge(
        modifier = modifier,
        text = type.name.lowercase().capitalize(locale = Locale.ROOT),
        backgroundColor = type.color()
    )
}

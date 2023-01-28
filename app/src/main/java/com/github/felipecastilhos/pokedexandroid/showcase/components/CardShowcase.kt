package com.github.felipecastilhos.pokedexandroid.showcase.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.PokemonMock
import com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components.PokemonListCard

@Preview("Pokemon List Card" , group = "Cards")
@Composable
fun PokemonListCardPreview() {
    val mock = PokemonMock.BULBASSAUR.pokemonDetails

    PokedexAndroidTheme {
        PokemonListCard(
            indexLabel = mock.pokedexId,
            image = R.drawable.asset_bulbasaur,
            pokemonName = mock.name,
            pokemonTypeColor = mock.types.first().color(),
            onClick = {}
        )
    }
}
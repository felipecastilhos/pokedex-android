package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.HomeTopAppBar
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListEntryUiData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListUiState
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components.PokemonListCard

@Composable
fun PokemonSearchScreen(
    modifier: Modifier = Modifier.background(PokedexTheme.colors.background.primary),
    onNavigateToPokemonDetails: (Int) -> Unit,
    uiState: PokemonListUiState,
) {
    uiState.apply {
        if (isLoading) {
            LoadingScreen()
        } else {
            Column(modifier = modifier) {
                HomeTopAppBar(title = "Pokédex", iconPainter = painterResource(id = PokedexTheme.icons.pokeball))
                Spacer(Modifier.height(8.dp))
                PokenonSearchList(
                    modifier = Modifier.fillMaxHeight(),
                    pokemons = pokemons,
                    onNavigateToPokemonDetails = onNavigateToPokemonDetails
                )
            }
        }
    }
}

@Composable
fun PokenonSearchList(
    modifier: Modifier = Modifier,
    pokemons: List<PokemonListEntryUiData>,
    onNavigateToPokemonDetails: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(3)
    ) {
//                .clickable(onClick = onNavigateToPokemonDetails),

        items(pokemons) { pokemon ->
            PokemonListCard(
                indexLabel = "#${pokemon.pokedexIndex}",
                image = pokemon.assetRes,
                pokemonName = pokemon.name,
                pokemonTypeColor = pokemon.type.color(),
                onClick = { onNavigateToPokemonDetails.invoke(pokemon.id) }
            )
        }
    }
}

@Composable
fun LoadingScreen() {
    Text("Carregando...")
}

@Composable
fun DetailScren() {
    Text("Some pokemon details")
}

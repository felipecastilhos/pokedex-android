package com.github.felipecastilhos.pokedexandroid.features.pokemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListEntryUiData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListViewModel

@Composable
fun PokemonSearchScreen(
    viewModel: PokemonListViewModel = hiltViewModel(),
    onNavigateToPokemonDetails: () -> Unit
) {
    val viewState = viewModel.stateFlow.collectAsState().value

    viewState.apply {
        if (isLoading) {
            LoadingScreen()
        } else {
            PokenonSearchList(
                pokemons = pokemons,
                onNavigateToPokemonDetails = onNavigateToPokemonDetails
            )
        }
    }
}

@Composable
fun PokenonSearchList(
    pokemons: List<PokemonListEntryUiData>,
    onNavigateToPokemonDetails: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        pokemons.forEach {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = onNavigateToPokemonDetails),
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    AsyncImage(model = it.thumbUrl, contentDescription = "")
                    Text(text = it.name.capitalize())
                }
            }
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

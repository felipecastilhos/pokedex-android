package com.github.felipecastilhos.pokedexandroid.features.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexandroidTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListEntryUiData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val pokemonListViewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonListViewModel
        setContent {
            val e by pokemonListViewModel.stateFlow.collectAsState()
            PokedexandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    if (e.isLoading) {
                        LogHandler.d("LOADING : ${e.isLoading}")
                        Text("Carregando...")
                    } else {
                        LogHandler.d("Pokemon Name: ${e}")
                        SearchPokemonResult(e.pokemons)
                    }
                }
            }
        }
    }
}


@Composable
fun SearchPokemonResult(
    pokemons: List<PokemonListEntryUiData>
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        pokemons.forEach {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}


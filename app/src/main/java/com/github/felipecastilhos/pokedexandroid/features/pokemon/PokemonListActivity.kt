package com.github.felipecastilhos.pokedexandroid.features.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexandroidTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
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
                    if (e.isSuccess) {
                        val pokemon = e.getOrNull()
                        if (pokemon == null) {
                            Text("Carregando...")
                        } else {
                            SearchPokemonResult(pokemon)
                        }
                    } else {
                        Text("${e.exceptionOrNull()?.localizedMessage}")
                    }
                }
            }
        }
    }
}


@Composable
fun SearchPokemonResult(
    pokemon: Pokemon
) {
    Column {
        Text("Pokemon Specie: ${pokemon.species.name}.")
        Text("Number: ${pokemon.pokedexNumber}")
        Text("Height: ${pokemon.height} ft")
        Text("Weight: ${pokemon.weight} lbs")
//        Text("Info: ${pokemon.flavorText.first().flavor}")
    }
}
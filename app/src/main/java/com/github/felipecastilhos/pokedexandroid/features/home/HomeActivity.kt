package com.github.felipecastilhos.pokedexandroid.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexandroidTheme
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.viewmodel.PokedexHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val pokedexHomeViewModel: PokedexHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokedexHomeViewModel
        setContent {
            val e by pokedexHomeViewModel.stateFlow.collectAsState()
            PokedexandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    when (e) {
                        Resource.Loading -> {
                            Text("Carregando...")
                        }
                        is Resource.Error -> {
                            Text("Ops, algo deu errado :(")
                        }
                        is Resource.Success -> {
                            SearchPokemonResult(
                                pokemonName = "Dragonite",
                                pokemonNumber = (e as Resource.Success<Pokemon?>).data?.pokedexNumber
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchPokemonResult(
    pokemonName: String,
    pokemonNumber: Int?
) {
    Text(text = "This is a $pokemonName. Pokemon Nbr.: ${pokemonNumber ?: "not found"}")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexandroidTheme {
        Greeting("Android")
    }
}

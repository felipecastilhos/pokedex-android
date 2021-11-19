package com.github.felipecastilhos.pokedexandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.ui.theme.PokedexandroidTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val pokedexHomeViewModel = PokedexHomeViewModel(PokemonUseCase())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            val e = pokedexHomeViewModel.searchPokemon()
            LogHandler.d("This is a Dragonite. Pokemon Nbr.: ${e?.getPokemon?.num}")
        }

        setContent {
            PokedexandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
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

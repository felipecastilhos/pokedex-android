package com.github.felipecastilhos.pokedexandroid

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
import com.github.felipecastilhos.pokedexandroid.features.home.PokedexHomeViewModel
import com.github.felipecastilhos.pokedexandroid.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.ui.theme.PokedexandroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val pokedexHomeViewModel: PokedexHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokedexHomeViewModel
        setContent {
            val e by pokedexHomeViewModel.stateFlow.collectAsState()
            e?.let {
                LogHandler.d("This is a Dragonite. Pokemon Nbr.: ${it.getPokemon.num}")
            }

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

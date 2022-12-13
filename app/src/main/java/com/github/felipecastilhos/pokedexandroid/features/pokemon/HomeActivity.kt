package com.github.felipecastilhos.pokedexandroid.features.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.github.felipecastilhos.pokedexandroid.PokemonNavGraph
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexandroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexandroidTheme {
                PokemonNavGraph()
            }
        }
    }
}

@Composable
fun PokemonDetailScreen() {
    Column {
        Text("Some details here")
    }
}

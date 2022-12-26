package com.github.felipecastilhos.pokedexandroid.features.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.github.felipecastilhos.pokedexandroid.PokemonNavGraph
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.ColorTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.LocalColorTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            val theme = changeTheme(isDarkTheme = isDarkTheme)
            PokedexAndroidTheme(darkTheme = isDarkTheme, colors = theme.colors) {
                PokemonNavGraph()
                Button(onClick = { isDarkTheme = !isDarkTheme }) {
                    Text("Change Theme")
                }
            }
        }
    }
}

@Composable
fun PokemonDetailScreen() {
    Column {
        Text("Some details here")
        Card(backgroundColor = LocalColorTheme.current.colors.pokemonType.ice) {
            Text("222222")
        }
    }
}

@Composable
fun changeTheme(isDarkTheme: Boolean): ColorTheme {
    return if (isDarkTheme) {
        ColorTheme.regular.darkMode
    } else {
        ColorTheme.regular.lightMode
    }
}
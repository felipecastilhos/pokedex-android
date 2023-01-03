package com.github.felipecastilhos.pokedexandroid.features.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.models.Showkase
import com.github.felipecastilhos.pokedexandroid.PokemonNavGraph
import com.github.felipecastilhos.pokedexandroid.core.ui.components.Badge
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.ColorScheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.getBrowserIntent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        setContent {
            PokedexAndroidTheme {
                Column {
                    PokemonNavGraph()
                    Row {
                        Spacer(Modifier.width(16.dp))
                        Button(onClick = { startActivity(Showkase.getBrowserIntent(context)) }) {
                            Text("Open Showcase")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun PokemonDetailScreen() {
    Column {
        Text("Some details here")
        Card(backgroundColor = PokedexTheme.colors.pokemonType.ice) {
            Text("222222")
        }
        Card(backgroundColor = PokedexTheme.colors.pokemonType.ice) {
            Text("333333")
        }
        Card(backgroundColor = PokedexTheme.colors.pokemonType.ice) {
            Text("444444")
        }
        Card(backgroundColor = PokedexTheme.colors.pokemonType.ice) {
            Text("555555")
        }
    }
}

@Composable
fun changeColorSchema(isDarkTheme: Boolean): ColorScheme {
    return if (isDarkTheme) {
        ColorScheme.regularDarkModeColorSchema()
    } else {
        ColorScheme.regularLightModeColorSchema()
    }
}
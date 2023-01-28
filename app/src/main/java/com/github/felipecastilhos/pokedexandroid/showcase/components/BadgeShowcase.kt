package com.github.felipecastilhos.pokedexandroid.showcase.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.core.ui.components.Badge
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TextBadge
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonType
import com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components.PokemonTypeBadge

@Preview(name = "Badge", group = "Badge")
@Composable
fun BadgePreview() {
    PokedexAndroidTheme {
        Badge(backgroundColor = PokedexTheme.colors.background.primary) {
            Text(text = "Just a badge")
        }
    }
}

@Preview(name = "TextBadge", group = "Badge")
@Composable
fun TextBadgePreview() {
    PokedexAndroidTheme {
        TextBadge(text = "TextBadge", backgroundColor = PokedexTheme.colors.background.primary)
    }
}


@Preview(name = "PokemonType", group = "Badge")
@Composable
fun BadgePokemonTypePreview() {
    PokedexAndroidTheme {
        PokemonTypeBadge(type = PokemonType.POISON)
    }
}
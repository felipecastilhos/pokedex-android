package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.CardDefaults
import com.github.felipecastilhos.pokedexandroid.core.ui.components.CardSmall
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme


@Composable
fun PokemonListCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    indexLabel: String,
    @DrawableRes image: Int,
    pokemonName: String,
    pokemonTypeColor: Color,
) {
    CardSmall(
        modifier.border(
            width = 1.dp,
            color = pokemonTypeColor,
            shape = CardDefaults.roundedShape
        ), onClick = onClick
    ) {
        Column(modifier) {
            IndexBadge(indexLabel = indexLabel, color = pokemonTypeColor)
            PokemonCardImage(pokemonImage = image)
            CardFooterLabel(pokemonName, pokemonTypeColor)
        }
    }
}

@Composable
private fun IndexBadge(
    modifier: Modifier = Modifier,
    indexLabel: String,
    color: Color,
) {
    Box(
        modifier = modifier
            .width(104.dp)
            .padding(horizontal = 8.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = indexLabel,
            style = PokedexTheme.typography.regular.subtitle,
            color = color,
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun PokemonCardImage(modifier: Modifier = Modifier, @DrawableRes pokemonImage: Int) {
    Row(modifier = modifier) {
        CardImageMargin()
        Image(
            painter = painterResource(id = pokemonImage),
            contentDescription = null
        )
        CardImageMargin()
    }
}

@Composable
private fun CardImageMargin() =
    Spacer(modifier = Modifier.width(16.dp))

@Composable
private fun CardFooterLabel(
    pokemonName: String,
    pokemonTypeColor: Color
) {
    Box(
        modifier = Modifier
            .width(104.dp)
            .background(pokemonTypeColor)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = pokemonName,
            style = PokedexTheme.typography.regular.body2,
            color = PokedexTheme.colors.background.surface,
            textAlign = TextAlign.Center
        )
    }
}






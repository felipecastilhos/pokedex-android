package com.github.felipecastilhos.pokedexandroid.uicatalog.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonMock


private val roundedShape = RoundedCornerShape(8.dp)

@Composable
fun CardSmall(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        shape = roundedShape
    ) {
        content.invoke()
    }
}

@Composable
fun PokemonListCard(
    modifier: Modifier = Modifier,
    indexLabel: String,
    @DrawableRes image: Int,
    pokemonName: String,
    pokemonTypeColor: Color,
) {
    CardSmall(modifier.border(width = 1.dp, color = pokemonTypeColor, shape = roundedShape), onClick = { /*TODO*/ }) {
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
    Box(modifier = modifier.width(104.dp).padding(horizontal = 8.dp)) {
        Text(modifier = Modifier.fillMaxWidth(), text = indexLabel, style = PokedexTheme.typography.regular.subtitle, color = color, textAlign = TextAlign.End)
    }
}

@Composable
private fun PokemonCardImage(modifier: Modifier = Modifier, @DrawableRes pokemonImage: Int) {
    Row {
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
            color = PokedexTheme.colors.content.overSurface,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun CardSmallPreview() {
    PokedexAndroidTheme {
        CardSmall(onClick = {}) {
            Text(text = "Cade essa merda?")
        }
    }
}

@Preview
@Composable
fun PokemonListCardPreview() {
    val mock = PokemonMock.BULBASSAUR.pokemonDetails

    PokedexAndroidTheme {
        PokemonListCard(
            indexLabel = mock.pokedexId,
            image = R.drawable.asset_bulbasaur,
            pokemonName = mock.name,
            pokemonTypeColor = mock.types.first().color()
        )
    }
}



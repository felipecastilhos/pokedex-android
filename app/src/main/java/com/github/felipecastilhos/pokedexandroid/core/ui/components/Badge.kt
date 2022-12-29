package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonType

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    backgroundColor: Color = Color(0xFFFFFFFF),
    horizontalPadding: Dp = 8.dp,
    verticalPadding: Dp = 2.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .padding(horizontal = horizontalPadding, verticalPadding)
    ) {
        content.invoke()
    }
}

@Composable
fun TextBadge(
    modifier: Modifier = Modifier,
    textColor: Color = Color(0xFF000000),
    backgroundColor: Color = Color(0xFFFFFFFF),
    text: String
) {
    Badge(modifier = modifier, backgroundColor = backgroundColor) {
        Text(text = text, style = PokedexTheme.typography.bold.body2, color = textColor)
    }

}

@Composable
fun PokemonTypeBadge(modifier: Modifier = Modifier, type: PokemonType) {
    TextBadge(
        modifier = modifier,
        text = type.name.lowercase().capitalize(),
        textColor = PokedexTheme.colors.content.overSurface,
        backgroundColor = type.color()
    )
}


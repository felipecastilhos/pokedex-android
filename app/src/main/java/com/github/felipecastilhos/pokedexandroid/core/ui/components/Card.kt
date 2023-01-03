package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.CardProperties.Companion.roundedShape
import com.github.felipecastilhos.pokedexandroid.core.ui.components.CardProperties.Companion.smallCardWidth
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun CardSmall(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .requiredWidth(smallCardWidth)
            .clickable(onClick = onClick),
        shape = roundedShape, backgroundColor = PokedexTheme.colors.background.surface
    ) {
        content.invoke()
    }
}

class CardProperties {
    companion object {
        val roundedShape = RoundedCornerShape(8.dp)
        val smallCardWidth = 104.dp
    }
}
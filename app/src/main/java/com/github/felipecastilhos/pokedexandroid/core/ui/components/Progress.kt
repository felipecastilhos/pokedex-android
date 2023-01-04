package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = PokedexTheme.colors.content.primary,
    backgroundColor: Color = PokedexTheme.colors.background.primary
) {
    LinearProgressIndicator(
        progress = progress,
        modifier = modifier
            .height(4.dp).clip(RoundedCornerShape(4.dp)),
        color = color,
        backgroundColor = backgroundColor
    )
}
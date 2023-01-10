package com.github.felipecastilhos.pokedexandroid.core.ui.components

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
    color: Color = ProgressBarDefaults.progressColor(),
    backgroundColor: Color = ProgressBarDefaults.backgroundColor()
) {
    LinearProgressIndicator(
        progress = progress,
        modifier = modifier
            .height(ProgressBarDefaults.height)
            .clip(RoundedCornerShape(ProgressBarDefaults.cornerRadius())),
        color = color,
        backgroundColor = backgroundColor
    )
}

object ProgressBarDefaults {
    val height = 4.dp
    @Composable fun progressColor() = PokedexTheme.colors.content.primary
    @Composable fun backgroundColor() = PokedexTheme.colors.background.primary
    @Composable fun cornerRadius() = PokedexTheme.radius.s300
}
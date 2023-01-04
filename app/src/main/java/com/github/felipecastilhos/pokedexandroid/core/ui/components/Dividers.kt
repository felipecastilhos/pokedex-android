package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette

@Composable
fun DividerVertical(
    modifier: Modifier = Modifier,
    color: Color = GrayscalePalette.defaultPalette().mediumGray
) {
    Divider(
        modifier
            .fillMaxHeight()
            .width(1.dp), color = color
    )
}
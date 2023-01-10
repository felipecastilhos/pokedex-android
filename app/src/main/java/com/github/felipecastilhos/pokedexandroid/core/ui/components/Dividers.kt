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
    color: Color = DividerDefaults.color
) {
    Divider(
        modifier
            .fillMaxHeight()
            .width(DividerDefaults.verticalWidth), color = color
    )
}

object DividerDefaults {
    val color = GrayscalePalette.defaultPalette().mediumGray
    val verticalWidth = 1.dp
}
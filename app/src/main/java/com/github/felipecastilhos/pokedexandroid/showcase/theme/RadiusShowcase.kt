package com.github.felipecastilhos.pokedexandroid.showcase.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Regular", group = "Atoms - Radius")
@Composable
fun RadiusShowcase() {
    PokedexAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            radiusToArray().forEach { spacings ->
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    SpacingBox(spacings.second)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = spacings.first
                    )
                }
            }
        }
    }
}

@Composable
private fun SpacingBox(radiusSize: Dp) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .border(
                width = 1.dp,
                color = GrayscalePalette.defaultPalette().darkGray,
                shape = RoundedCornerShape(radiusSize)
            )
            .background(PokedexTheme.colors.background.primary)
    )
}

@Composable
private fun radiusToArray(): List<Pair<String, Dp>> {
    return mutableListOf(
        Pair("s200", PokedexTheme.radius.s000),
        Pair("s300", PokedexTheme.radius.s300),
        Pair("s400", PokedexTheme.radius.s400),
        Pair("s500", PokedexTheme.radius.s500),
    )
}

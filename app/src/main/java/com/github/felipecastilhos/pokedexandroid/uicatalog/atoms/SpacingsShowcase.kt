package com.github.felipecastilhos.pokedexandroid.uicatalog.atoms

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

@Preview(name = "Regular", group = "Atoms - Spacings")
@Composable
fun SpacingsShowcase() {
    PokedexAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            regularTypographyToArray().forEach { spacings ->
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
private fun SpacingBox(size: Dp) {
    Box(
        modifier = Modifier
            .size(size)
            .border(
                width = 1.dp,
                color = GrayscalePalette.defaultPalette().darkGray,
                shape = RoundedCornerShape(0.dp)
            )
            .background(PokedexTheme.colors.background.primary)
    )
}

@Composable
private fun regularTypographyToArray(): List<Pair<String, Dp>> {
    return mutableListOf(
        Pair("s200", PokedexTheme.spacings.s200),
        Pair("s300", PokedexTheme.spacings.s300),
        Pair("s400", PokedexTheme.spacings.s400),
        Pair("s500", PokedexTheme.spacings.s500),
    )
}

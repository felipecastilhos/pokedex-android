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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Regular", group = "Atoms - Typography")
@Composable
fun TypographyRegularShowcase() {
    PokedexAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            regularTypographyToArray().forEach { textStyle ->
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    TypographyBox(textStyle.second)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = textStyle.first
                    )
                }
            }
        }
    }
}

@Preview(name = "Bold", group = "Atoms - Typography")
@Composable
fun TypographyBoldShowcase() {
    PokedexAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            boldTypographyToArray().forEach { textStyle ->
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    TypographyBox(textStyle.second)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = textStyle.first
                    )
                }
            }
        }
    }
}

@Composable
private fun TypographyBox(textStyle: TextStyle) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .border(
                width = 1.dp,
                color = GrayscalePalette.defaultPalette().darkGray,
                shape = RoundedCornerShape((10.dp))
            )
            .clip(RoundedCornerShape((10.dp)))
            .background(PokedexTheme.colors.background.primary)
    ) {
        Text(
            modifier = Modifier.align(Center),
            text = "Aa",
            color = PokedexTheme.colors.content.primary,
            style = textStyle
        )
    }
}

@Composable
private fun regularTypographyToArray(): List<Pair<String, TextStyle>> {
    return mutableListOf(
        Pair("h1", PokedexTheme.typography.regular.h1),
        Pair("h2", PokedexTheme.typography.regular.h2),
        Pair("body1", PokedexTheme.typography.regular.body1),
        Pair("body2", PokedexTheme.typography.regular.body2),
        Pair("subtitle", PokedexTheme.typography.regular.subtitle)
    )
}

@Composable
private fun boldTypographyToArray(): List<Pair<String, TextStyle>> {
    return mutableListOf(
        Pair("h1", PokedexTheme.typography.bold.h1),
        Pair("h2", PokedexTheme.typography.bold.h2),
        Pair("body1", PokedexTheme.typography.bold.body1),
        Pair("body2", PokedexTheme.typography.bold.body2),
        Pair("subtitle", PokedexTheme.typography.bold.subtitle)
    )
}
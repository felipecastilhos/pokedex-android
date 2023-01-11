package com.github.felipecastilhos.pokedexandroid.showcase.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.felipecastilhos.pokedexandroid.core.ui.components.DividerVertical
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme

@Preview(name= "Divider Vertical", group = "Divider")
@Composable
fun VerticalDividerShowcase() {
    PokedexAndroidTheme {
        DividerVertical()
    }
}
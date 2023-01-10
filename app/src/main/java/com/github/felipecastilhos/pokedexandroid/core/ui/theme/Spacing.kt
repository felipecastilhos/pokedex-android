package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Spacing(
    val s200: Dp,
    val s300: Dp,
    val s400: Dp,
    val s500: Dp
) {
    companion object {
        fun regular() = Spacing(s200 = 4.dp, s300 = 8.dp, s400 = 16.dp, s500 = 24.dp)
    }
}
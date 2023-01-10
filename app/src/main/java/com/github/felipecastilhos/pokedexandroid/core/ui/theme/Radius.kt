package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


class Radius(
    val s000: Dp = 0.dp,
    val s300: Dp,
    val s400: Dp,
    val s500: Dp
) {
    companion object {
        fun regular() = Radius(s300 = 2.dp, s400 = 4.dp, s500 = 8.dp)
    }
}
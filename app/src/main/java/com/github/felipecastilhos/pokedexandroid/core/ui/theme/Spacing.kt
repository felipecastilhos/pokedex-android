package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Spacings represents paddings, margins and spacers of elements in the screen. This should not be used
 * to represent widths and heights of any element.
 */
class Spacing(
    val s100: Dp,
    val s200: Dp,
    val s300: Dp,
    val s400: Dp,
    val s500: Dp
) {
    companion object {
        fun regular() = Spacing(s100 = 2.dp, s200 = 4.dp, s300 = 8.dp, s400 = 16.dp, s500 = 24.dp)
    }
}

/**
 * CompositionLocal used to pass [Spacing] down the tree.
 *
 * Setting the value here is typically done as part of [PokedexTheme], which will
 * automatically handle efficiently updating any changed radius values without causing unnecessary
 * recompositions..
 * To retrieve the current value of this CompositionLocal, use [PokedexTheme.spacings].
 */
val LocalSpacings = compositionLocalOf {
    Spacing.regular()
}
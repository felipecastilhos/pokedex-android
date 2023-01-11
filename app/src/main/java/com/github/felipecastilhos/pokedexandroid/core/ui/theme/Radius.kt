package com.github.felipecastilhos.pokedexandroid.core.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * Radius is used as a token for round shapes in applications. Use this wherever you need to soften an edge.
 */
class Radius(
    val s000: Dp,
    val s300: Dp,
    val s400: Dp,
    val s500: Dp
) {
    companion object {
        fun regular() = Radius(s000 = 0.dp, s300 = 4.dp, s400 = 8.dp, s500 = 10.dp)
    }
}


/**
 * CompositionLocal used to pass [Radius] down the tree.
 *
 * Setting the value here is typically done as part of [PokedexTheme], which will
 * automatically handle efficiently updating any changed radius values without causing unnecessary
 * recompositions..
 * To retrieve the current value of this CompositionLocal, use [PokedexTheme.radius].
 */
val LocalRadius = compositionLocalOf {
    Radius.regular()
}
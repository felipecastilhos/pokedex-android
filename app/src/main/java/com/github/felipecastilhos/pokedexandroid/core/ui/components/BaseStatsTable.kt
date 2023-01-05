package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun BaseStatsTable(
    labelColor: Color = PokedexTheme.colors.content.primary,
    valueColor: Color = PokedexTheme.colors.content.primary,
    modifier: Modifier = Modifier,
    stats: List<BaseStatsTableEntry>,
    barColor: Color
) {
    Column(modifier = modifier) {
        stats.forEach {
            Row(modifier = Modifier.height(16.dp)) {
                Text(
                    modifier = Modifier.width(29.dp),
                    text = it.statsName,
                    textAlign = TextAlign.End,
                    style = PokedexTheme.typography.bold.body1,
                    color = labelColor
                )
                Spacer(Modifier.width(8.dp))
                DividerVertical(color = GrayscalePalette.defaultPalette().lightGray)
                Spacer(Modifier.width(8.dp))
                Text(
                    "%03d".format(it.statsValue.toInt()),
                    style = PokedexTheme.typography.regular.body1,
                    color = valueColor
                )
                Spacer(Modifier.width(8.dp))
                ProgressBar(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    progress = it.statsValue,
                    color = barColor
                )
            }
        }
    }
}

class BaseStatsTableEntry(val statsName: String, val statsValue: Float)

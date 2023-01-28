package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun BaseStatsTable(
    stats: List<BaseStatsTableEntry>,
    barColor: Color,
    modifier: Modifier = Modifier,
    labelColor: Color = BaseStatsTableDefaults.contentColor(),
    valueColor: Color = BaseStatsTableDefaults.contentColor(),
) {
    Column(modifier = modifier) {
        stats.forEach {
            Row(modifier = Modifier.height(16.dp)) {
                Text(
                    modifier = Modifier.width(29.dp),
                    text = it.statsName,
                    textAlign = TextAlign.End,
                    style = BaseStatsTableDefaults.infoTitleStyle(),
                    color = labelColor
                )
                Spacer(Modifier.width(BaseStatsTableDefaults.internalSpacing()))
                DividerVertical()
                Spacer(Modifier.width(BaseStatsTableDefaults.internalSpacing()))
                Text(
                    "%03d".format(it.statsValue.toInt()),
                    style = BaseStatsTableDefaults.infoStyle(),
                    color = valueColor
                )
                Spacer(Modifier.width(BaseStatsTableDefaults.internalSpacing()))
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

object BaseStatsTableDefaults {
    @Composable
    fun contentColor() = PokedexTheme.colors.content.primary
    @Composable
    fun internalSpacing() = PokedexTheme.spacings.s300
    @Composable
    fun infoTitleStyle() = PokedexTheme.typography.bold.body1
    @Composable
    fun infoStyle() = PokedexTheme.typography.regular.body1

}
package com.github.felipecastilhos.pokedexandroid.features.pokemon.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.DividerVertical
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme


@Composable
fun AboutPanelLayout(
    modifier: Modifier = Modifier,
    startSlot: @Composable () -> Unit,
    middleSlot: @Composable () -> Unit,
    endSlot: @Composable () -> Unit,
    dividerColor: Color = GrayscalePalette.defaultPalette().lightGray
) {
    Row(
        modifier = modifier
            .height(52.dp)
    ) {
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            startSlot.invoke()
        }
        DividerVertical(color = dividerColor)
        Spacer(Modifier.width(12.dp))
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            middleSlot.invoke()
        }
        DividerVertical(color = dividerColor)
        Spacer(Modifier.width(12.dp))
        Box(modifier = Modifier, contentAlignment = Alignment.TopEnd) {
            endSlot.invoke()
        }

    }
}

@Composable
fun AboutPanelIconInfo(
    modifier: Modifier = Modifier,
    iconLabelPainter: Painter,
    textLabel: String,
    informationTitle: String,
    iconColor: Color
) {
    AboutPanelInfo(information = {
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = iconLabelPainter,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = iconColor)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = textLabel,
                style = PokedexTheme.typography.regular.body1,
                color = PokedexTheme.colors.content.primary
            )
        }
    }, informationTitle = informationTitle)
}

@Composable
fun AboutPanelListInfo(
    modifier: Modifier = Modifier,
    infoList: List<String>,
    informationTitle: String,
    textColor: Color = PokedexTheme.colors.content.primary
) {
    AboutPanelInfo(information = {
        Column(modifier = modifier) {
            infoList.forEach { text ->
                Text(
                    text = text,
                    style = PokedexTheme.typography.regular.body1,
                    color = textColor
                )
            }
        }
    }, informationTitle = informationTitle)
}

@Composable
fun AboutPanelInfo(information: @Composable () -> Unit, informationTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(74.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        information.invoke()
        Text(
            modifier = Modifier
                .weight(1f, false)
                .fillMaxWidth(),
            text = informationTitle,
            textAlign = TextAlign.Center,
            style = PokedexTheme.typography.regular.body2,
            color = PokedexTheme.colors.content.primary,
        )
    }
}
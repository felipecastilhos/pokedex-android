package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.DividerVertical
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.GrayscalePalette
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme


@Composable
fun AboutPanelLayout(
    startSlot: @Composable () -> Unit,
    middleSlot: @Composable () -> Unit,
    endSlot: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .height(52.dp)
            .width(290.dp)
    ) {
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            startSlot.invoke()
        }
        DividerVertical()
        Spacer(Modifier.width(12.dp))
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            middleSlot.invoke()
        }
        DividerVertical()
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
            color = GrayscalePalette.defaultPalette().mediumGray,
        )
    }
}
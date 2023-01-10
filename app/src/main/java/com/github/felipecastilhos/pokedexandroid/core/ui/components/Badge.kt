package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(BadgeDefaults.badgeRadius()),
    backgroundColor: Color = BadgeDefaults.backgroundColor(),
    horizontalPadding: Dp = BadgeDefaults.horizontalPadding(),
    verticalPadding: Dp = BadgeDefaults.verticalPadding(),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .padding(horizontal = horizontalPadding, verticalPadding)
    ) {
        content.invoke()
    }
}

@Composable
fun TextBadge(
    modifier: Modifier = Modifier,
    textColor: Color = BadgeDefaults.contentColor(),
    backgroundColor: Color = BadgeDefaults.backgroundColor(),
    text: String
) {
    Badge(modifier = modifier, backgroundColor = backgroundColor) {
        Text(text = text, style = PokedexTheme.typography.bold.body2, color = textColor)
    }
}

object BadgeDefaults {
    @Composable
    fun verticalPadding() = PokedexTheme.spacings.s100
    @Composable
    fun horizontalPadding() = PokedexTheme.spacings.s300
    @Composable
    fun badgeRadius() = PokedexTheme.radius.s500
    @Composable
    fun backgroundColor() = PokedexTheme.colors.background.surface
    @Composable
    fun contentColor() = PokedexTheme.colors.content.overSurface
}


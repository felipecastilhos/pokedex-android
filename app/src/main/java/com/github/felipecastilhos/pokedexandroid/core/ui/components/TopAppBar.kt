package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun BackTopAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    title: String,
    actions: @Composable RowScope.() -> Unit,
    contentColor: Color = PokedexTheme.colors.content.primary,
    backgroundColor: Color = PokedexTheme.colors.background.primary,
) {
    PokedexTopAppBar(
        modifier = modifier,
        title = { TopAppBarTitle(title = title, textColor = contentColor) },
        actions = actions,
        navigationIcon = { NavigationBackIcon(onNavigationBackClick = onBackClick, iconColor = contentColor) },
        backgroundColor = backgroundColor,
    )
}

@Composable
fun HomeTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    contentColor: Color = PokedexTheme.colors.content.primary,
    backgroundColor: Color = PokedexTheme.colors.background.primary,
) {
    PokedexTopAppBar(
        modifier = modifier,
        title = { TopAppBarTitle(title = title, textColor = contentColor) },
        navigationIcon = {
            Row {
                Spacer(Modifier.width(16.dp))
                TopAppBarIcon(
                    iconPainter = iconPainter,
                    iconColor = PokedexTheme.colors.content.primary
                )
            }
        },
        backgroundColor = backgroundColor,
        actions = {}
    )
}


@Composable
fun PokedexTopAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    backgroundColor: Color
) {
    TopAppBar(
        modifier = modifier,
        title = title,
        navigationIcon = navigationIcon,
        backgroundColor = backgroundColor,
        elevation = elevation,
        actions = actions
    )
}

@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    textColor: Color = PokedexTheme.colors.content.primary,
    style: TextStyle = PokedexTheme.typography.bold.h1,
    title: String,
) {
    Text(
        modifier = modifier.wrapContentHeight(),
        style = style,
        text = title,
        color = textColor,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun NavigationBackIcon(
    onNavigationBackClick: () -> Unit,
    iconPainter: Painter = painterResource(id = PokedexTheme.icons.arrow_left),
    iconColor: Color = PokedexTheme.colors.content.primary
) {
    TopAppBarIconButton(
        iconPainter = iconPainter,
        iconColor = iconColor,
        onClick = onNavigationBackClick,
        contentDescription = "Go back"
    )
}

@Composable
fun TopAppBarIcon(
    iconPainter: Painter,
    iconColor: Color,
) {
    Image(
        modifier = Modifier.size(24.dp),
        painter = iconPainter,
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = iconColor)
    )
}

@Composable
fun TopAppBarIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentDescription: String?,
    iconPainter: Painter,
    iconColor: Color,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Image(
            painter = iconPainter,
            colorFilter = ColorFilter.tint(iconColor),
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
fun TopAppBarIconPreview() {
    PokedexAndroidTheme {
        HomeTopAppBar(
            title = "Pokedex",
            iconPainter = painterResource(id = PokedexTheme.icons.pokeball),
        )
    }
}

@Preview
@Composable
fun BackTopAppBarPreview() {
    PokedexAndroidTheme {
        BackTopAppBar(title = "Pokédex", onBackClick = {}, actions = {})
    }
}
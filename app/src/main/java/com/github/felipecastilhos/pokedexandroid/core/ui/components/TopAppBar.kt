package com.github.felipecastilhos.pokedexandroid.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TopAppBarDefaults.iconStartPadding
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Composable
fun BackTopAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    title: String,
    actions: @Composable RowScope.() -> Unit,
    contentColor: Color = TopAppBarDefaults.contentColor(),
    backgroundColor: Color = TopAppBarDefaults.backgroundColor(),
) {
    PokedexTopAppBar(
        modifier = modifier,
        title = { TopAppBarTitle(title = title, textColor = contentColor) },
        actions = actions,
        navigationIcon = {
            NavigationBackIcon(
                onNavigationBackClick = onBackClick,
                iconColor = contentColor
            )
        },
        backgroundColor = backgroundColor,
    )
}

@Composable
fun HomeTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    contentColor: Color = TopAppBarDefaults.contentColor(),
    backgroundColor: Color = TopAppBarDefaults.backgroundColor(),
) {
    PokedexTopAppBar(
        modifier = modifier,
        title = { TopAppBarTitle(title = title, textColor = contentColor) },
        navigationIcon = {
            Row {
                Spacer(Modifier.width(iconStartPadding()))
                TopAppBarIcon(
                    iconPainter = iconPainter,
                    iconColor = contentColor
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
    textColor: Color = TopAppBarDefaults.contentColor(),
    style: TextStyle = TopAppBarDefaults.titleTextStyle(),
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
    iconPainter: Painter = painterResource(id = TopAppBarDefaults.backIcon()),
    iconColor: Color = TopAppBarDefaults.contentColor()
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


object TopAppBarDefaults {
    @Composable
    fun contentColor() = PokedexTheme.colors.content.primary
    @Composable
    fun backgroundColor() = PokedexTheme.colors.background.primary
    @Composable
    fun iconStartPadding() = PokedexTheme.spacings.s400
    @Composable
    fun titleTextStyle() = PokedexTheme.typography.bold.h1
    @Composable
    fun backIcon() = PokedexTheme.icons.arrow_left
}



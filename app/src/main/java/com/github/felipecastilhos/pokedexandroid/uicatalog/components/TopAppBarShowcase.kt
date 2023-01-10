package com.github.felipecastilhos.pokedexandroid.uicatalog.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BackTopAppBar
import com.github.felipecastilhos.pokedexandroid.core.ui.components.PokedexTopAppBar
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TopAppBarIcon
import com.github.felipecastilhos.pokedexandroid.core.ui.components.TopAppBarTitle
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme


@Preview(name = "Pokedex TopAppBar", group = "TopAppBar")
@Composable
fun PokedexTopAppBarPreview() {
    PokedexAndroidTheme {
        PokedexTopAppBar(
            modifier = Modifier,
            title = { TopAppBarTitle(title = "Pokedex", textColor = PokedexTheme.colors.content.primary) },
            navigationIcon = {
                Row {
                    Spacer(Modifier.width(16.dp))
                    TopAppBarIcon(
                        iconPainter = painterResource(id = PokedexTheme.icons.pokeball),
                        iconColor = PokedexTheme.colors.content.primary
                    )
                }
            },
            backgroundColor = PokedexTheme.colors.background.primary,
            actions = {}
        )
    }
}



@Preview(name = "Pokedex TopAppBar", group = "TopAppBar Back Action")
@Composable
fun BackTopAppBarPreview() {
    PokedexAndroidTheme {
        BackTopAppBar(title = "Pokédex", onBackClick = {}, actions = {})
    }
}
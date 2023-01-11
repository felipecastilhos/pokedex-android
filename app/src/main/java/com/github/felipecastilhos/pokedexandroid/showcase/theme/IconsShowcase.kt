package com.github.felipecastilhos.pokedexandroid.showcase

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme

@Preview(name = "Icons", group = "Atoms - Icons")
@Composable
fun IconsShowkase() {
    PokedexAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            iconSchemeToArray().forEach {
                IconCatalog(iconName = it.first, iconRes = it.second )
            }
        }
    }
}


@Composable
private fun IconCatalog(iconName: String, @DrawableRes iconRes: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
      Icon(iconRes)
        Text(
            modifier = Modifier.align(CenterVertically) ,
            text = iconName
        )
    }

}

@Composable
private fun Icon(@DrawableRes iconRes: Int) {
    Image(
        modifier = Modifier.width(24.dp),
        painter = painterResource(iconRes),
        contentDescription = null
    )
}

@Composable
private fun iconSchemeToArray(): MutableList<Pair<String, Int>> {
    return mutableListOf(
        Pair("pokeball", PokedexTheme.icons.pokeball),
        Pair("arrow_left", PokedexTheme.icons.arrow_left),
        Pair("arrow_down", PokedexTheme.icons.arrow_down),
        Pair("magnifying_glass", PokedexTheme.icons.magnifying_glass),
        Pair("ruler", PokedexTheme.icons.ruler),
        Pair("weight", PokedexTheme.icons.weight)
    )
}
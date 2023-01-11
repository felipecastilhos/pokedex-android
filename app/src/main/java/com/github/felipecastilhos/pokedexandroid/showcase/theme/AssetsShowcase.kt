package com.github.felipecastilhos.pokedexandroid.showcase

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipecastilhos.pokedexandroid.R

@Preview(name="Pokemon Assets", "Assets")
@Composable
fun AssetsCatalog() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        assetsToArray().forEach {
            AssetCatalog(iconName = it.first, iconRes = it.second)
        }
    }
}

@Composable
private fun AssetCatalog(iconName: String, @DrawableRes iconRes: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        AssetImage(iconRes)
        Text(
            modifier = Modifier.align(Alignment.CenterVertically) ,
            text = iconName
        )
    }

}

@Composable
private fun AssetImage(@DrawableRes iconRes: Int) {
    Image(
        modifier = Modifier.width(24.dp),
        painter = painterResource(iconRes),
        contentDescription = null
    )
}
fun assetsToArray(): MutableList<Pair<String, Int>> {
    return mutableListOf(
        Pair("asset_aron", R.drawable.asset_aron),
        Pair("asset_bulbasaur", R.drawable.asset_bulbasaur),
        Pair("asset_butterfree", R.drawable.asset_butterfree),
        Pair("asset_charmander", R.drawable.asset_charmander),
        Pair("asset_ditto", R.drawable.asset_ditto),
        Pair("asset_gastly", R.drawable.asset_gastly),
        Pair("asset_mew", R.drawable.asset_mew),
        Pair("asset_pikachu", R.drawable.asset_pikachu),
        Pair("asset_silhouette", R.drawable.asset_silhouette),
        Pair("asset_squirtle", R.drawable.asset_squirtle)
    )
}

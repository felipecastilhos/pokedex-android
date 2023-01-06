package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BackTopAppBar
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BaseStatsTable
import com.github.felipecastilhos.pokedexandroid.core.ui.components.BaseStatsTableEntry
import com.github.felipecastilhos.pokedexandroid.core.ui.components.PokemonTypeBadge
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexTheme
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.PokemonDetails
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.PokemonType
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.Stats
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components.AboutPanelIconInfo
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components.AboutPanelLayout
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.components.AboutPanelListInfo

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    backgroundColor: Color = PokedexTheme.colors.background.primary,
    pokemonDetails: PokemonDetails
) {
    val typeColor = pokemonDetails.types.first().color()

    ConstraintLayout(
        modifier = Modifier
            .background(typeColor)
            .fillMaxHeight()
    ) {
        val (topbar, pokeballBackgroundImage, pokemonImage, pokemonInfoCard, infoContent) = createRefs()
        Image(
            modifier = Modifier.constrainAs(pokeballBackgroundImage) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            painter = painterResource(PokedexTheme.icons.pokeball),
            alpha = 0.1F,
            colorFilter = ColorFilter.tint(PokedexTheme.colors.content.overSurface),
            contentDescription = null
        )
        BackTopAppBar(modifier = Modifier.constrainAs(topbar) {
            top.linkTo(parent.top)
        },
            onBackClick = { },
            title = pokemonDetails.name,
            contentColor = PokedexTheme.colors.content.overSurface,
            backgroundColor = Color.Transparent,
            actions = {
                Text(pokemonDetails.pokedexId, color = PokedexTheme.colors.content.overSurface)
            })

        Box(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(PokedexTheme.colors.background.primary)
            .constrainAs(pokemonInfoCard) {
                top.linkTo(pokeballBackgroundImage.bottom, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 4.dp)
                end.linkTo(parent.end, margin = 4.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

        Image(
            modifier = Modifier
                .size(200.dp)
                .constrainAs(pokemonImage) {
                    top.linkTo(topbar.bottom, margin = 24.dp)
                    start.linkTo(parent.start, margin = 80.dp)
                    end.linkTo(parent.end, margin = 80.dp)
                },
            painter = painterResource(id = R.drawable.asset_bulbasaur),
            contentDescription = null
        )

        PokemonInfoContent(
            modifier = Modifier
                .constrainAs(infoContent) {
                    top.linkTo(pokemonImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 20.dp),
            pokemonDetails = pokemonDetails,
            primaryColor = typeColor
        )


    }
}

@Composable
private fun PokemonInfoContent(
    modifier: Modifier, pokemonDetails: PokemonDetails, primaryColor: Color
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PokemonTypeBadges(modifier = Modifier.fillMaxWidth(), typeList = pokemonDetails.types)
        AboutSection(pokemonDetails = pokemonDetails, subtitleColor = primaryColor)
        BaseStatsSection(pokemonDetails = pokemonDetails, subtitleColor = primaryColor)
    }
}

@Composable
private fun ColumnScope.AboutSection(pokemonDetails: PokemonDetails, subtitleColor: Color) {
    Subtitle(subtitle = "About", color = subtitleColor)
    AboutPanelPokemonInfo(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        weightText = pokemonDetails.weight,
        heightText = pokemonDetails.height,
        movesList = pokemonDetails.moves
    )
    AboutDescription(text = pokemonDetails.aboutDescription)
}

@Composable
private fun ColumnScope.BaseStatsSection(pokemonDetails: PokemonDetails, subtitleColor: Color) {
    Subtitle(subtitle = "Base Stats", color = subtitleColor)
    BaseStatsTable(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        stats = pokemonDetails.baseStats.toStatsTableEntry(),
        labelColor = subtitleColor,
        barColor = subtitleColor,
    )
}

@Composable
private fun Subtitle(modifier: Modifier = Modifier, subtitle: String, color: Color) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = subtitle,
        style = PokedexTheme.typography.bold.h2,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun AboutDescription(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = PokedexTheme.colors.content.primary
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = text,
        style = PokedexTheme.typography.regular.body2,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun PokemonTypeBadges(modifier: Modifier = Modifier, typeList: List<PokemonType>) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.spacedBy(
            16.dp, alignment = Alignment.CenterHorizontally
        )
    ) {
        typeList.forEach { type ->
            PokemonTypeBadge(type = type)
        }
    }
}

@Composable
private fun AboutPanelPokemonInfo(
    modifier: Modifier = Modifier,
    weightText: String,
    heightText: String,
    movesList: List<String>
) {
    AboutPanelLayout(modifier = modifier, startSlot = {
        AboutPanelIconInfo(
            iconLabelPainter = painterResource(id = PokedexTheme.icons.weight),
            textLabel = weightText,
            informationTitle = "Weight",
            iconColor = PokedexTheme.colors.content.primary
        )
    }, middleSlot = {
        AboutPanelIconInfo(
            iconLabelPainter = painterResource(id = PokedexTheme.icons.ruler),
            textLabel = heightText,
            informationTitle = "Height",
            iconColor = PokedexTheme.colors.content.primary
        )
    }, endSlot = {
        AboutPanelListInfo(
            infoList = movesList,
            informationTitle = "Moves",
        )
    })
}

private fun Stats.toStatsTableEntry(): List<BaseStatsTableEntry> {
    return mutableListOf(
        BaseStatsTableEntry(statsName = "HP", statsValue = hp.toFloat()),
        BaseStatsTableEntry(statsName = "ATK", statsValue = atk.toFloat()),
        BaseStatsTableEntry(statsName = "DEF", statsValue = def.toFloat()),
        BaseStatsTableEntry(statsName = "SATK", statsValue = satk.toFloat()),
        BaseStatsTableEntry(statsName = "SDEF", statsValue = sdef.toFloat()),
        BaseStatsTableEntry(statsName = "SPD", statsValue = spd.toFloat()),
    )
}

@Preview
@Composable
fun PokemonDetailScreenPreview() {
    PokedexAndroidTheme {
        PokemonDetailScreen(
            pokemonDetails = PokemonDetails(
                pokedexId = "#001",
                name = "Bulbassaur",
                types = mutableListOf(PokemonType.GRASS, PokemonType.POISON),
                weight = "6,9 kg",
                height = "0,7 m",
                moves = mutableListOf("Chlorophyll", "Overgrow"),
                aboutDescription = "There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.",
                baseStats = Stats(
                    hp = 45, atk = 49, def = 49, satk = 65, sdef = 65, spd = 45
                )
            )
        )
    }
}

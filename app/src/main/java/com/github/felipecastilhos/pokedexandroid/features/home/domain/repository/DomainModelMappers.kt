package com.github.felipecastilhos.pokedexandroid.features.home.domain.repository

import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.FlavorText
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.PokemonTypes

fun GetPokemonQuery.GetPokemon.mapToDomainModel(): Pokemon = Pokemon(
    pokedexNumber = this.num,
    species = this.species,
    types = this.types.toTypesDomainModel(),
    height = this.height,
    weight = this.weight,
    flavorText = this.flavorTexts.toFlavorListDomainModel()
)

fun List<GetPokemonQuery.FlavorText>.toFlavorListDomainModel(): List<FlavorText> = map {
    it.toFlavorListDomainModel()
}

fun GetPokemonQuery.FlavorText.toFlavorListDomainModel(): FlavorText =
    FlavorText(game = game, flavor = flavor)

fun List<String>.toTypesDomainModel(): List<PokemonTypes?> = map {
    it.mapToTypesDomainModel()
}

fun String.mapToTypesDomainModel(): PokemonTypes? =
    try {
        PokemonTypes.valueOf(this)
    } catch (e: IllegalArgumentException) {
        LogHandler.d("Não foi converter para modelo de domínio")
        null
    }
